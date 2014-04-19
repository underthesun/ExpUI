/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Configuration;
import main.MainFrame;
import util.Configurator;

/**
 *
 * @author b1106
 */
public class CommunicationTool {

    private MainFrame frame;
    private DatagramSocket dataSocket;
    private Receiver receiver;
    private Sender sender;
    Configuration configuration;
    Gson gson;

    public CommunicationTool(MainFrame frame) {
        this.frame = frame;

        configuration = Configurator.parseConfiguration(new File("ui_conf.json"));
        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            dataSocket = new DatagramSocket(configuration.UI_PORT);
        } catch (SocketException ex) {
            Logger.getLogger(CommunicationTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.receiver = new Receiver(this, dataSocket);
        new Thread(receiver).start();
        this.sender = new Sender(dataSocket);
    }

    public void parseData(String ip, int port, String data) {
        Message message = gson.fromJson(data, Message.class);
        String mType = message.getType();
        if (mType.equals(Message.REGISTER)) {
            frame.register(message.getId());
        } else if (mType.equals(Message.HEARTBEAT)) {
            frame.heartbeat(message.getId());
        } else if (mType.equals(Message.INT_ECHO)) {
            frame.intEcho(message.getId(), message.getContent());
        } else if (mType.equals(Message.INT_REPORT)) {
            frame.intReport(message.getId(), message.getContent());
        }

    }

    public void sendMessage(String ip, int port, String data) {
        sender.sendMessage(ip, port, data);
    }

    public void intStart() {
        Message m = new Message();
        m.setType(Message.INT_START);
        sendMessage(configuration.SERVER_ADDR, configuration.SERVER_PORT, gson.toJson(m, Message.class));
    }
}

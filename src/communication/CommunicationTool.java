/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Configuration;
import main.MainFrame;
import util.Configurator;
import util.ProcessSim;

/**
 * 监控端对底层通信进行封装的工具类
 *
 * @author b1106
 */
public class CommunicationTool {

    private MainFrame frame;
    private DatagramSocket dataSocket;
    private Receiver receiver;
    private Sender sender;
    private Configuration configuration;
    private Gson gson;

    /**
     * 构造通信工具实例，构造UDP套接字。 套接字端口号从配置文件中获取，并构造Receiver和Sender的实例用以收发数据包
     *
     * @param frame
     */
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

    /**
     * 通信工具类数据解析接口
     *
     * @param ip 数据包地址
     * @param port 数据包端口号
     * @param data 数据
     */
    public void parseData(String ip, int port, String data) {
        Message message = gson.fromJson(data, Message.class);
        String mType = message.getType();
        if (mType.equals(Message.HEARTBEAT)) {
            frame.heartbeat(message.getId());
        } else if (mType.equals(Message.INT_ECHO)) {
            frame.intEcho(message.getId(), message.getContent());
        } else if (mType.equals(Message.INT_REPORT)) {
            frame.intReport(message.getId(), message.getContent());
        } else if (mType.equals(Message.PROCESS_ONLINE)) {
            Set<ProcessSim> processSims = gson.fromJson(message.getContent(), new TypeToken<Set<ProcessSim>>() {
            }.getType());
            frame.processOnline(processSims);
        }

    }

    /**
     * 通信工具数据发送接口，通过调用Sender的信息发送方法sendMessage发送数据
     *
     * @param ip 数据包地址
     * @param port 数据包端口号
     * @param data 数据
     * @see Sender#sendMessage(java.lang.String, int, java.lang.String)
     */
    public void sendMessage(String ip, int port, String data) {
        sender.sendMessage(ip, port, data);
    }

    /**
     * 发送退出命令接口
     * @see Message#KILL
     */
    public void sendKill() {
        Message m = new Message();
        m.setType(Message.KILL);
        sendMessage(configuration.SERVER_ADDR, configuration.SERVER_PORT, gson.toJson(m, Message.class));
    }

    /**
     * 发送完整性验证启动命令接口
     * @see Message#INT_START
     */
    public void intStart() {
        Message m = new Message();
        m.setType(Message.INT_START);
        sendMessage(configuration.SERVER_ADDR, configuration.SERVER_PORT, gson.toJson(m, Message.class));
    }

    /**
     * 发送在线过程请求命令接口
     * @see Message#PROCESS_ONLINE
     */
    public void requestProcessOnline() {
        Message m = new Message();
        m.setType(Message.PROCESS_ONLINE);
        sendMessage(configuration.SERVER_ADDR, configuration.SERVER_PORT, gson.toJson(m, Message.class));
    }
}

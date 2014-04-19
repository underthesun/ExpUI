/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author b1106
 */
public class Configuration {

    public String SERVER_ADDR = "localhost";
    public int SERVER_PORT = 6666;
    public int UI_PORT = 6667;

    public String getSERVER_ADDR() {
        return SERVER_ADDR;
    }

    public void setSERVER_ADDR(String SERVER_ADDR) {
        this.SERVER_ADDR = SERVER_ADDR;
    }
    
    public int getSERVER_PORT() {
        return SERVER_PORT;
    }

    public void setSERVER_PORT(int SERVER_PORT) {
        this.SERVER_PORT = SERVER_PORT;
    }

    public int getUI_PORT() {
        return UI_PORT;
    }

    public void setUI_PORT(int UI_PORT) {
        this.UI_PORT = UI_PORT;
    }
    
}

package pkg.paradise.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import pkg.paradise.gamestate.PlayState;

public final class Sender {

    private static final int PORT = 4445;
    private static final String HOST = "localhost";
    private static DatagramSocket sock;

    /****************************************************
     * Name: setSocket
     * Description: Used to keep the socket between
     * receiver and sender uniform. Required due to its 
     * static nature.
     ****************************************************/
    public static void setSocket(DatagramSocket sock) {
        Sender.sock = sock;
    }

    /****************************************************
     * Name: sendMessage
     * Description: Actually sends the message to the 
     * server. Protocol:Data1:Data2
     ****************************************************/
    private static void sendMessage(String s) {
        byte buf[] = s.getBytes();
        try {
            InetAddress address = InetAddress.getByName(HOST);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
            sock.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /****************************************************
     * Name: update
     * Description: Updates server with every ~60 times 
     * per second, with the actual players information. 
     * Protocol:Move:direction:newX:newY
     ****************************************************/
    public static void update() {
        String mv = PlayState.player.getMoving();
        String dir = Integer.toString(PlayState.player.getDir());
        String nx = Integer.toString(PlayState.player.x);
        String ny = Integer.toString(PlayState.player.y);
        String send = "MOVE:" + mv + ":" + dir + ":" + nx + ":" + ny;
        sendMessage(send);

    }

    /****************************************************
     * Name: sendChatMessage
     * Description: Sends CHAT protocol message to server
     * for distrubution to other clients. 
     * Protocol:Message
     ****************************************************/
    public static void sendChatMessage(String msg) {
        String send = "CHAT:" + msg;
        sendMessage(send);
    }
}

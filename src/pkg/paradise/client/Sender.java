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

    private Sender(DatagramSocket sock) {
        super();
        Sender.sock = sock;
    }

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

    //Update single players values to server
    //~60 times per second
    public static void update() {
        String mv = PlayState.player.getMoving();
        String dir = Integer.toString(PlayState.player.getDir());
        String nx = Integer.toString(PlayState.player.x);
        String ny = Integer.toString(PlayState.player.y);
        String send = mv + ":" + dir + ":" + nx + ":" + ny;
        sendMessage(send);

    }
    
    public static void sendChatMessage(String msg){
        sendMessage(msg);
    }
    
    public static void setSocket(DatagramSocket sock){
        Sender.sock = sock;
    }
}

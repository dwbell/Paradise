package pkg.paradise.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import pkg.paradise.gamestate.PlayState;

public class Sender {

    private final int PORT = 4445;
    private final String hostname = "localhost";
    private DatagramSocket sock;

    public Sender(DatagramSocket sock) {
        super();
        this.sock = sock;
    }

    private void sendMessage(String s) {
        byte buf[] = s.getBytes();
        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
            sock.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Update single players values to server
    //~60 times per second
    public void update() {
        String mv = PlayState.player.getMoving();
        String dir = Integer.toString(PlayState.player.getDir());
        String nx = Integer.toString(PlayState.player.x);
        String ny = Integer.toString(PlayState.player.y);
        String send = mv + ":" + dir + ":" + nx + ":" + ny;
        sendMessage(send);

    }
}

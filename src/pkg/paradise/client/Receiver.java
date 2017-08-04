package pkg.paradise.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import pkg.paradise.entity.mob.NetPlayer;
import pkg.paradise.gamestate.PlayState;

public class Receiver implements Runnable {

    private byte buf[];
    private final int BUFFER = 256;
    private DatagramSocket socket;
    private final long SLEEP_TIME = 5L;

    public Receiver(DatagramSocket socket) {
        super();
        this.socket = socket;
        buf = new byte[BUFFER];
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Receive a packet
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                //Receive string and dissect it id:dir:x:y
                String received = new String(packet.getData(), 0, packet.getLength());
                received = received.trim();
                String[] coords = received.split(":");
                String id = coords[0];
                int moving = Integer.parseInt(coords[1]);
                int dir = Integer.parseInt(coords[2]);
                int tx = Integer.parseInt(coords[3]);
                int ty = Integer.parseInt(coords[4]);

                //Only add if it's new, checked by address and port
                if (!PlayState.netPlayers.containsKey(id)) {
                    PlayState.netPlayers.put(id, new NetPlayer(tx, ty));
                }

                //Set respected id to new x,y position
                PlayState.netPlayers.get(id).setMoving(moving);
                PlayState.netPlayers.get(id).setDir(dir);
                PlayState.netPlayers.get(id).setX(tx);
                PlayState.netPlayers.get(id).setY(ty);

                System.out.println(moving + ":" + dir + ":" + tx + "," + ty);
                sleep(SLEEP_TIME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
        }
    }
}

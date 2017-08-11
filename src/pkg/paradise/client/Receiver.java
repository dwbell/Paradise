package pkg.paradise.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import pkg.paradise.entity.mob.NetPlayer;
import pkg.paradise.gamestate.PlayState;
import pkg.paradise.main.Game;

public class Receiver implements Runnable {

    private byte buf[];
    private final int BUFFER = 256;
    private DatagramSocket socket;
    private final long SLEEP_TIME = 5L;
    private final char newLine = '\n';

    public Receiver(DatagramSocket socket) {
        super();
        this.socket = socket;
        buf = new byte[BUFFER];
    }

    /****************************************************
     * Name: run
     * Description: Runnable's overriden method, which 
     * contains the new Threads work load. Receiver 
     * really needed it's own thread to constantly listen 
     * for the server message from others. 
     ****************************************************/
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

                //Check its protocol and act accordingly
                switch (getProtocol(received)) {
                    case "CHAT":
                        String s[] = received.split(":");
                        //String prot = coords[1];
                        String msg = s[2];
                        //Add to text area
                        Game.textArea.append(msg + newLine);

                        break;
                    case "MOVE":
                        String[] coords = received.split(":");
                        String id = coords[0];
                        //String prot = coords[1];
                        int moving = Integer.parseInt(coords[2]);
                        int dir = Integer.parseInt(coords[3]);
                        int tx = Integer.parseInt(coords[4]);
                        int ty = Integer.parseInt(coords[5]);

                        //Only add if it's new, checked by address and port
                        if (!PlayState.netPlayers.containsKey(id)) {
                            PlayState.netPlayers.put(id, new NetPlayer(tx, ty));
                        }

                        //Set respected id to new x,y position
                        PlayState.netPlayers.get(id).setMoving(moving);
                        PlayState.netPlayers.get(id).setDir(dir);
                        PlayState.netPlayers.get(id).setX(tx);
                        PlayState.netPlayers.get(id).setY(ty);
                        //System.out.println(moving + ":" + dir + ":" + tx + "," + ty);
                        break;
                    default:
                        System.out.println("Receiver.java - Switch statement failed");
                        break;
                }
                sleep(SLEEP_TIME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /****************************************************
     * Name: getProtocol
     * Description: Checks the received string for which
     * protocol was received. 
     ****************************************************/
    public String getProtocol(String message) {
        if (message.contains("CHAT")) {
            return "CHAT";
        } else {
            return "MOVE";
        }
    }

    /****************************************************
     * Name: sleep
     * Description: Simple sleep method
     ****************************************************/
    public void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
        }
    }
}

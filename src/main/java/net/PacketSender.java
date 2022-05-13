package net;

import java.net.*;

public class PacketSender {
    DatagramSocket socket;
    public PacketSender(byte[] buf) {
        try {
            socket = new DatagramSocket();
            socket.connect(InetAddress.getLocalHost(), 8123);
            socket.send(new DatagramPacket(buf, buf.length));
        } catch (Exception e) { e.printStackTrace(); }
    }
}

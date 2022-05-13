package net;

import java.io.IOException;
import java.net.*;

public class PacketSender {
    DatagramSocket socket;
    public PacketSender(byte[] buf) throws UnknownHostException {
        try {
            socket = new DatagramSocket();
            socket.connect(InetAddress.getByAddress(new byte[] {(byte) 192, (byte) 168, (byte) 0, (byte) 149}), 8123);
            socket.send(new DatagramPacket(buf, buf.length));
        } catch (Exception e) { e.printStackTrace(); }
    }
}

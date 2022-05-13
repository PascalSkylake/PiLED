package net;

import java.io.IOException;
import java.net.*;

public class PacketSender {
    DatagramSocket socket;
    public PacketSender(byte[] buf) throws UnknownHostException {
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        socket.connect(InetAddress.getLocalHost(), 8123);
        try {
                socket.send(new DatagramPacket(buf, buf.length));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

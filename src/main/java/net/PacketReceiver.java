package net;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class PacketReceiver extends Thread {
    private DatagramSocket socket;
    private Inet4Address address;
    private DatagramPacket packet;
    private byte[] buf;

    public PacketReceiver() {
        try {
            socket = new DatagramSocket(8123, InetAddress.getLocalHost());
            address = (Inet4Address) Inet4Address.getByAddress(new byte[]{10, 43, 42, 2});
            start();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void receivePacket() {
        try {
            buf = new byte[1024];
            Integer out = 0;
            packet = new DatagramPacket(buf, 1024);
            socket.receive(packet);
            buf = packet.getData();
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(bais);
            out = (Integer) ois.readObject();
            System.out.println(out);
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void run() {
        super.run();
        receivePacket();
    }

    @Override
    public void start() {
        super.start();
    }
}

package net;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Arrays;

public class PacketReceiver implements Runnable {
    private DatagramSocket socket;
    private Inet4Address address;
    private byte[] buf;

    public PacketReceiver() {
        try {
            socket = new DatagramSocket(8123, InetAddress.getLocalHost());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void receivePacket() {
        try {
            buf = new byte[1024];
            Integer out;
            DatagramPacket packet = new DatagramPacket(buf, 1024);
            socket.receive(packet);
            buf = packet.getData();
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            ObjectInputStream ois = new ObjectInputStream(bais);
            out = (Integer) ois.readObject();
            System.out.println(out);
        } catch (Exception e) { e.printStackTrace(); }
        Arrays.fill(buf, (byte) 0);
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            receivePacket();
        }
    }
}

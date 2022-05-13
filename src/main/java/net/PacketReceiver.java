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
            socket = new DatagramSocket(8123);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            address = (Inet4Address) Inet4Address.getByAddress(new byte[] {10, 43, 42, 2});
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        start();
    }

    public void receivePacket() {
        buf = new byte[1024];
        Integer out = 0;
        packet = new DatagramPacket(buf, 1024);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.out.println("failed to receive packet (epic fail)");
        }
        buf = packet.getData();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
            out = (Integer) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(out);
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

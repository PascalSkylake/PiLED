package net;

import led.LEDController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Arrays;

public class PacketReceiver implements Runnable {
    private DatagramSocket socket;

    public PacketReceiver() {
        try {
            socket = new DatagramSocket(8123, InetAddress.getLocalHost());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void receivePacket() {
        try {
            byte[] buf = new byte[1024];
            State received;
            DatagramPacket packet = new DatagramPacket(buf, 1024);
            ByteArrayInputStream byteInput = new ByteArrayInputStream(buf);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);

            socket.receive(packet);
            received = (State) objectInput.readObject();

            if (received != LEDController.current) {
                LEDController.current = received;
                LEDController.strip.switchTo(State.getPattern(received));
            }
        } catch (Exception e) { e.printStackTrace(); }
    }


    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            receivePacket();
        }
    }
}

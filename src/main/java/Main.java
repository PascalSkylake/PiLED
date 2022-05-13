import net.PacketSender;
import net.PacketReceiver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PacketReceiver receiver = new PacketReceiver();
        Thread t = new Thread(receiver);
        t.start();
        System.out.println("waiting");

    }
}

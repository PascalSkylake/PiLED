import net.PacketSender;
import net.PacketReceiver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int in = (int) (Math.random() * 10000000);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(baos);
                os.writeObject(os);
                PacketSender sender = new PacketSender(baos.toByteArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Main lock = new Main();
            synchronized (lock) {
                try {
                    lock.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

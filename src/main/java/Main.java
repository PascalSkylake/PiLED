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
            Scanner kb = new Scanner(System.in);
            int in = kb.nextInt();
            Integer integer = in;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(baos);
            os.writeObject(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


            try {
                PacketSender sender = new PacketSender(baos.toByteArray());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

    }
}

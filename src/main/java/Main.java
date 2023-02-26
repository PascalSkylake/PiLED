import led.LEDController;
import led.patterns.AutoBlue;
import led.patterns.AutoRed;
import led.patterns.Yellow;
import led.patterns.Purple;
import net.State;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LEDController controller = new LEDController(300);
	    controller.strip.switchTo(new AutoBlue(State.AUTOBLUE));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String temp = scanner.nextLine();
            if (temp.equals("b"))
                controller.strip.switchTo(new AutoBlue(State.AUTOBLUE));
            else if (temp.equals("r"))
                controller.strip.switchTo(new AutoRed(State.AUTORED));
            else if (temp.equals("y"))
                controller.strip.switchTo(new Yellow(State.YELLOW));
            else if (temp.equals("p"))
                controller.strip.switchTo(new Purple(State.PURPLE));
        }

        /*
        while (true) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream os;
            State test = State.AUTOBLUE;
            Integer out = 12;
            try {
                PacketReceiver receiver = new PacketReceiver();
                strip = new LEDStrip(100);
                Thread t = new Thread(receiver);
                t.start();
                os = new ObjectOutputStream(baos);
                os.writeObject(test);
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


        PacketReceiver receiver = new PacketReceiver();
        Thread t = new Thread(receiver);
        t.start();
        System.out.println("waiting");

         */

    }
}

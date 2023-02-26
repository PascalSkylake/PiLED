import led.LEDController;
import led.patterns.AutoBlue;
import led.patterns.AutoRed;
import led.patterns.Yellow;
import led.patterns.Purple;
import led.patterns.Rainbow;
import led.patterns.Off;
import net.State;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LEDController controller = new LEDController(88);
	    controller.strip.switchTo(new Yellow(State.YELLOW));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String temp = scanner.nextLine();
            System.out.println(temp);
            if (temp.equals("b")) {
                controller.strip.switchTo(new AutoBlue(State.AUTOBLUE));
                continue;
            }
            else if (temp.equals("r")) {
                controller.strip.switchTo(new AutoRed(State.AUTORED));
                continue;
            }
            else if (temp.equals("y")) {
                controller.strip.switchTo(new Yellow(State.YELLOW));
                continue;
            }
            else if (temp.equals("p")) {
                controller.strip.switchTo(new Purple(State.PURPLE));
                continue;
            }
            else if (temp.equals("rb")) {
                controller.strip.switchTo(new Rainbow(State.RAINBOW));
                continue;
            }
            else if (temp.equals("off")) {
                controller.strip.switchTo(new Off(State.OFF));
                continue;
            }
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

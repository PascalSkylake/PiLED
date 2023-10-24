import led.LEDController;
import led.patterns.AutoBlue;
import led.patterns.AutoRed;
import led.patterns.Yellow;
import led.patterns.Purple;
import led.patterns.Rainbow;
import led.patterns.Off;
import led.patterns.Silly;
import net.State;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LEDController controller = new LEDController(147);
	    controller.strip.switchTo(new Silly(5, State.SILLY));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String temp = scanner.nextLine();
            int tickrate = Integer.parseInt(temp.split(" ")[1]);
            temp = temp.split(" ")[0];
            System.out.println(temp + tickrate);
            if (temp.equals("b")) {
                controller.strip.switchTo(new AutoBlue(tickrate, State.AUTOBLUE));
                continue;
            }
            else if (temp.equals("r")) {
                controller.strip.switchTo(new AutoRed(tickrate, State.AUTORED));
                continue;
            }
            else if (temp.equals("y")) {
                controller.strip.switchTo(new Yellow(tickrate, State.YELLOW));
                continue;
            }
            else if (temp.equals("p")) {
                controller.strip.switchTo(new Purple(tickrate, State.PURPLE));
                continue;
            }
            else if (temp.equals("rb")) {
                controller.strip.switchTo(new Rainbow(tickrate, State.RAINBOW));
                continue;
            }
            else if (temp.equals("off")) {
                controller.strip.switchTo(new Off(tickrate, State.OFF));
                continue;
            }
            else if (temp.equals("silly")) {
                controller.strip.switchTo(new Silly(tickrate, State.SILLY));
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

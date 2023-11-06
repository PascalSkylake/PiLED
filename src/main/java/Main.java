import led.LEDController;
import led.patterns.AutoBlue;
import led.patterns.AutoRed;
import led.patterns.Color;
import led.patterns.Rainbow;
import led.patterns.Off;
import led.patterns.Silly;
import net.State;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LEDController controller = new LEDController(147);
	    LEDController.strip.switchTo(new Silly());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String temp = scanner.nextLine();
            temp = temp.split(" ")[0];
            switch (temp) {
                case "b" -> {
                    LEDController.strip.switchTo(new AutoBlue(State.AUTOBLUE));
                }
                case "r" -> {
                    LEDController.strip.switchTo(new AutoRed(State.AUTORED));
                }
                case "y" -> {
                    LEDController.strip.switchTo(new Color());
                }
                case "rb" -> {
                    LEDController.strip.switchTo(new Rainbow());
                }
                case "off" -> {
                    LEDController.strip.switchTo(new Off());
                }
                case "silly" -> {
                    LEDController.strip.switchTo(new Silly());
                }
            }
        }



    }
}

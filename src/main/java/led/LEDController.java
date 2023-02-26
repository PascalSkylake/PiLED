package led;

import net.State;

public class LEDController {
    public static LEDStrip strip;
    public static State current;

    public LEDController(int stripLength) {
        strip = new LEDStrip(stripLength);
    }
}

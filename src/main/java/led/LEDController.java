package led;

import net.PacketReceiver;
import net.State;

public class LEDController {
    public static Thread receiver;
    public static LEDStrip strip;
    public static State current;

    public LEDController(int stripLength) {
        receiver = new Thread(new PacketReceiver());
        strip = new LEDStrip(stripLength);
        receiver.start();
    }
}

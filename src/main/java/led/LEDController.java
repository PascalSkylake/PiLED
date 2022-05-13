package led;

import net.PacketReceiver;

public class LEDController {
    public static Thread receiver;
    public static LEDStrip strip;

    public LEDController(int stripLength) {
        receiver = new Thread(new PacketReceiver());
        strip = new LEDStrip(stripLength);
        receiver.start();
    }
}

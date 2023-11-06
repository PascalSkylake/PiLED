package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class Off extends Pattern {
    public Off() {
        super(State.OFF);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            setPixelColorRGB(i, 0, 0, 0);
        }
    }
}
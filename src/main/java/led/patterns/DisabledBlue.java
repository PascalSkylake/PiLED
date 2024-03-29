package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class DisabledBlue extends Pattern {
    public DisabledBlue(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            setPixelColorRGB(i, 0, 0, 255);
        }
    }
}

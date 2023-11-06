package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class DisabledRed extends Pattern {
    public DisabledRed(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            setPixelColorRGB(i, 255, 0, 0);
        }
    }
}

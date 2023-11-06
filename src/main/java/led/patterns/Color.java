package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class Color extends Pattern {
    float hue;
    public Color() {
        super(State.COLOR);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            setPixelColorHSB(i, hue, 1f, 1f);
        }
    }
}

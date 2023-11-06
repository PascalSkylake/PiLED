package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoRed extends Pattern {
    public AutoRed(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            double alternate = (100d / 2) * ((-Math.cos((2 * Math.PI * 4 * i) / LEDStrip.length)) + 1);
            setPixelColorRGB((i + LEDStrip.counter) % LEDStrip.length, 255, (int) alternate, 0);
        }
    }
}

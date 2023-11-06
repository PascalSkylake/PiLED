package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoBlue extends Pattern {
    public AutoBlue(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            double alternate = (200d / 2) * ((-Math.cos((2 * Math.PI * 4 * i) / LEDStrip.length)) + 1);
            setPixelColorRGB((i + LEDStrip.counter) % LEDStrip.length, 0, (int) alternate, 255);
        }
    }
}

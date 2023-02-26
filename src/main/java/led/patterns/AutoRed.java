package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoRed extends Pattern {
    public AutoRed(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            double alternate = (70 / 2) * ((-Math.cos((2 * Math.PI * 6 * i) / LEDController.strip.length)) + 1);
            LEDController.strip.setPixelColourRGB((i + counter) % LEDController.strip.length, 0, (int) alternate, 255);
        }
        LEDController.strip.render();
    }
}

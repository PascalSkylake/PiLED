package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class Rainbow extends Pattern {
    public Rainbow(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            LEDController.strip.setPixelColourHSL((i + LEDStrip.counter) % LEDController.strip.length, ((float) i / LEDController.strip.length) * 360, 1f, 0.5f);
        }
        LEDController.strip.render();
    }
}
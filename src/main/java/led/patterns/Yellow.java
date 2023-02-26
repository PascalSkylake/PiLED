package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class Yellow extends Pattern {
    public Yellow(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            LEDController.strip.setPixelColourRGB(i, 0, 255, 255);
        }
        LEDController.strip.render();
    }
}

package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoBlue extends Pattern {
    public AutoBlue(State name) {
        super(name);
    }

    @Override
    public void setPixels() {
        boolean goingUp;
        for (int i = 1; i <= LEDStrip.length; i++) {
            goingUp = !(i % 30 >= 15);
            if (goingUp) {
                LEDController.strip.setPixelColourRGB(i - 1, 0, Math.min(((i % 30) * 13), 180), 255);
            } else {
                LEDController.strip.setPixelColourRGB(i - 1, 0, Math.max((180 - (i + 15) % 30), 0), 255);
            }
        }
        LEDController.strip.render();
    }
}

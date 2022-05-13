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
        boolean goingUp;
        for (int i = 1; i <= LEDStrip.length; i++) {
            goingUp = !(i % 30 >= 15);

            if (goingUp) {
                LEDController.strip.setPixelColourRGB(i - 1, 255, Math.min(((i % 30) * 13), 180), 0);
            } else {
                LEDController.strip.setPixelColourRGB(i - 1, 255, Math.max((180 - ((i + 15) % 30) * 13), 0), 0);
            }

        }
        LEDController.strip.render();
    }
}

package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;
import java.awt.Color;

public class Yellow extends Pattern {
    public Yellow(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            LEDController.strip.setPixelColourRGB(i, 0, 0, 0);
        }
        for (int i = 0; i < LEDController.strip.length; i++) {
            LEDController.strip.setPixelColourRGB(i, 255, 170, 0);
        }
        LEDController.strip.render();
    }
}

package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class Off extends Pattern {
    public Off(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            LEDController.strip.setPixelColourRGB(i, 0, 0, 0);
        }
        LEDController.strip.render();
    }
}
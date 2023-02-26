package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class DisabledBlue extends Pattern {
    public DisabledBlue(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            LEDController.strip.setPixelColourRGB(i, 0, 0, 255);
        }
        LEDController.strip.render();
    }
}

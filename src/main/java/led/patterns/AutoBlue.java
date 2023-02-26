package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoBlue extends Pattern {
    public AutoBlue(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            double alternate = (200 / 2) * ((-Math.cos((2 * Math.PI * 4 * i) / LEDController.strip.length)) + 1);
            LEDController.strip.setPixelColourRGB((i + LEDStrip.counter) % LEDController.strip.length, 0, (int) alternate, 255);
        }
        LEDController.strip.render();
    }
}

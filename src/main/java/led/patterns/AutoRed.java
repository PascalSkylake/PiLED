package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class AutoRed extends Pattern {
    public AutoRed(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            double alternate = (100 / 2) * ((-Math.cos((2 * Math.PI * 4 * i) / LEDController.strip.length)) + 1);
            LEDController.strip.setPixelColourRGB((i + LEDStrip.counter) % LEDController.strip.length, 255, (int) alternate, 0);
        }
        LEDController.strip.render();
    }
}

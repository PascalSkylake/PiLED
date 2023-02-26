package led.patterns;

import java.util.Random;
import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class Silly extends Pattern {
    Random random;
    public Silly(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
        random = new Random();
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDController.strip.length; i++) {
            LEDController.strip.setPixelColourHSL(i, (float) (random.nextDouble() * 360), 1f, 0.5f);
        }
        LEDController.strip.render();
    }
}
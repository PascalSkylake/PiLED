package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class Silly extends Pattern {
    public Silly() {
        super(State.SILLY);
    }

    @Override
    public void setPixels() {
        if (LEDStrip.counter % 20 == 0) {
            for (int i = 0; i < LEDStrip.length; i++) {
                setPixelColorHSB(i, (random.nextFloat()), 1f, 1f);
            }
        }
    }
}
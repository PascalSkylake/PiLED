package led.patterns;

import led.LEDStrip;
import led.Pattern;
import net.State;

public class Rainbow extends Pattern {
    public Rainbow() {
        super(State.RAINBOW);
    }



    @Override
    public void setPixels() {
        currentPosition += speedFactor;
        for (int i = 0; i < LEDStrip.length; i++) {
            float adjustedPosition = (i + currentPosition) % LEDStrip.length;

            if (adjustedPosition < 0) {
                adjustedPosition += LEDStrip.length;
            }
            float hue = (adjustedPosition / LEDStrip.length) * 360;

            // Set the pixel color
            setPixelColorHSB(i, hue, 1f, 0.5f);
        }
    }
}

package led.patterns;

import led.Pattern;
import net.State;

public class Sawtooth extends Pattern {
    public Sawtooth() {
        super(State.SAWTOOTH);
    }

    @Override
    public void setPixels() {
        speedFactor = -1f;
        currentPosition += speedFactor;
        for (int i = 0; i < pixelArray.length; i++) {
            float adjustedPosition = (i + currentPosition) % pixelArray.length;

            if (adjustedPosition < 0) {
                adjustedPosition += pixelArray.length;
            }

            float j = (((1f / 100f) * adjustedPosition) % 1);


            setPixelColorHSB(i, 240f / 360f, 1f, j);
        }
    }
}

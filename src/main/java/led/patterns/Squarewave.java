package led.patterns;

import led.Pattern;
import net.State;

public class Squarewave extends Pattern {
    public Squarewave() {
        super(State.SQUAREWAVE);
    }

    @Override
    public void setPixels() {
        speedFactor = -0.1f;
        currentPosition += speedFactor;

        for (int i = 0; i < pixelArray.length; i++) {
            float adjustedPosition = (i + currentPosition) % pixelArray.length;

            if (adjustedPosition < 0) {
                adjustedPosition += pixelArray.length;
            }

            float j = (float) Math.abs(Math.pow(Math.sin((((Math.PI / 2) * adjustedPosition) * (0.02 * sections))), 2));

            if (j > 0.5) {
                j = 1;
            } else {
                j = 0;
            }

            setPixelColorHSB(i, 0f, 1f, j);
        }
    }
}

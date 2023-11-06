package led.patterns;

import led.Pattern;
import net.State;

public class Triangle extends Pattern {
    public Triangle() {
        super(State.TRIANGLE);
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

            float j = 2 * Math.abs(Math.round(adjustedPosition / (pixelArray.length / sections)) - (adjustedPosition / (pixelArray.length / sections)));

            setPixelColorHSB(i, (float) i / pixelArray.length, 1f, j);
        }
    }
}

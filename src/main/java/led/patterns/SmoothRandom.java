package led.patterns;

import led.Pattern;
import net.State;

import java.awt.Color;

public class SmoothRandom extends Pattern {
    public SmoothRandom() {
        super(State.SMOOTHRANDOM);
    }

    @Override
    public void setPixels() {
        //speedFactor = 3 * (float) Math.sin((Math.PI / 500) * (counter % 100)) + 2;
        Color[] temp = pixelArray;
        Color[] next = new Color[pixelArray.length];
        if (next[0] == null) {
            for (int i = 0; i < next.length; i++) {
                next[i] = Color.getHSBColor(random.nextFloat(), 1f, 1f);
            }
        }

        for (int i = 0; i < pixelArray.length; i++) {
            float[] thsb = getHSB(temp[i]);
            float[] nhsb = getHSB(next[i]);

            if (Math.abs(thsb[0] - nhsb[0]) < 0.01 && Math.abs(thsb[1] - nhsb[1]) < 0.01 && Math.abs(thsb[2] - nhsb[2]) < 0.01) {
                next[i] = Color.getHSBColor(random.nextFloat(), 1f, 1f);
            } else if (Math.abs(Math.abs(thsb[0] - nhsb[0])) >= 0.01) {
                if (nhsb[0] - thsb[0] <= 0) {
                    thsb[0] = thsb[0] - (nhsb[0] - thsb[0]) / (1 / (speedFactor / 50));
                } else {
                    thsb[0] = thsb[0] + (nhsb[0] - thsb[0]) / (1 / (speedFactor / 50));
                }

            }

            temp[i] = Color.getHSBColor(thsb[0], 1f, 1f);
        }
    }
}

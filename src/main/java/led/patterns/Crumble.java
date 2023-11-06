package led.patterns;

import led.Pattern;
import net.State;

import java.awt.Color;
import java.util.Arrays;

public class Crumble extends Pattern {
    public Crumble() {
        super(State.CRUMBLE);
    }

    @Override
    public void setPixels() {
        boolean allOff = true;
        for (Color color : pixelArray) {
            if (getHSB(color)[2] != 0) {
                allOff = false;
            }
        }

        if (allOff) {
            Arrays.fill(pixelArray, Color.getHSBColor(240f / 360f, 1f, 1f));
        } else {
            for (int i = 0; i < pixelArray.length; i++) {
                if (random.nextInt() % (int) ((1f / speedFactor) * 100) == 0) {
                    pixelArray[i] = new Color(0);
                }
            }
        }
    }
}

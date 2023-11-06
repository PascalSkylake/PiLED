package led;

import net.State;

import java.awt.*;
import java.util.Random;

public abstract class Pattern implements Runnable {
    public State name;
    private boolean running;
    protected float speedFactor = 1f;
    protected float sections = 5f;
    protected float currentPosition = 0f;
    protected Color[] pixelArray;
    protected Random random;

    public Pattern(State name) {
        this.name = name;
        running = true;
        pixelArray = new Color[LEDStrip.length];
        this.random = new Random();
    }

    /**
     * Implemented in a pattern, doesn't really matter what it does, just has to set pixel colors
     */
    public abstract void setPixels();

    public void setPixelColorHSB(int i, float h, float s, float b) {
        pixelArray[i] = Color.getHSBColor(h, s, b);
    }

    public void setPixelColorRGB(int i, int r, int g, int b) {
        pixelArray[i] = new Color(r, g, b);
    }

    public void stop() {
        running = false;
    }

    private void setStripToArray() {
        float[] hsb;

        for (int i = 0; i < pixelArray.length; i++) {
            hsb = getHSB(pixelArray[i]);
            LEDController.strip.setPixelColourHSB(i, (int) (hsb[0] * 360f), hsb[1], hsb[2]);
        }
    }

    protected float[] getHSB(Color c) {
        float[] rgb = new float[3];
        rgb = c.getRGBColorComponents(rgb);

        rgb[0] /= 255f;
        rgb[1] /= 255f;
        rgb[2] /= 255f;

        float cmax = Math.max(rgb[0], Math.max(rgb[1], rgb[2]));
        float cmin = Math.min(rgb[0], Math.min(rgb[1], rgb[2]));
        float diff = cmax - cmin;
        float h = -1, s;

        if (cmax == cmin) {
            h = 0;
        }

        else if (cmax == rgb[0]) {
            h = (60 * ((rgb[1] - rgb[2]) / diff) + 360) % 360;
        }

        // if cmax equal g then compute h
        else if (cmax == rgb[1]) {
            h = (60 * ((rgb[2] - rgb[0]) / diff) + 120) % 360;
        }

        // if cmax equal b then compute h
        else if (cmax == rgb[2]) {
            h = (60 * ((rgb[0] - rgb[1]) / diff) + 240) % 360;
        }

        // if cmax equal zero
        if (cmax == 0) {
            s = 0;
        } else {
            s = (diff / cmax) * 100;
        }

        h /= 360;
        s /= 100;
        float b = cmax * 255;


        return new float[] {h, s, b};
    }

    /**
     * runs setPixels() and increments the counter, ticks at ticksPerSecond
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / 100d;
        double delta = 0;

        while (running) {
            try {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            catch (Exception e) {
                return;
            }
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                setPixels();
                LEDStrip.counter++;
                setStripToArray();
                LEDController.strip.render();
                delta--;
            }
        }
    }
}

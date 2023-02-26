package led;

import com.diozero.ws281xj.rpiws281x.WS281x;

public class LEDStrip extends WS281x {
    public static Thread runningPattern;
    public static int length;
    public static int counter;

    public LEDStrip(int numPixels) {
        super(18, 255, numPixels);
        length = numPixels;
        for (int i = 0; i < length; i++) {
            setPixelColourRGB(i, 255, 255, 255);
        }
        counter = 0;
        render();
    }

    public void switchTo(Pattern p) {
        if (runningPattern != null) {
            runningPattern.interrupt();
        }
        
        runningPattern = new Thread(p);
        runningPattern.start();
    }
}

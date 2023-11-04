package led.patterns;

import led.LEDController;
import led.LEDStrip;
import led.Pattern;
import net.State;

public class Rainbow extends Pattern {
    private float speedFactor = 1.0f; // Initial speed factor

    public Rainbow(int ticksPerSecond, State name) {
        super(ticksPerSecond, name);
    }

    // Method to set the speed factor
    public void setSpeedFactor(float speedFactor) {
        this.speedFactor = speedFactor;
    }

    @Override
    public void setPixels() {
        for (int i = 0; i < LEDStrip.length; i++) {
            // Calculate the adjusted position based on speedFactor
            int adjustedPosition = (int) ((i + LEDStrip.counter * speedFactor) % LEDStrip.length);

            // Calculate the hue based on the adjusted position
            float hue = ((float) adjustedPosition / LEDStrip.length) * 360;

            // Set the pixel color
            LEDController.strip.setPixelColourHSL(adjustedPosition, hue, 1f, 0.5f);
        }
        LEDController.strip.render();
    }
}

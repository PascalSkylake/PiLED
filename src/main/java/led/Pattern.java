package led;

import net.State;

public abstract class Pattern implements Runnable {
    public State name;
    private boolean running;
    protected int ticksPerSecond;

    public Pattern(int ticksPerSecond, State name) {
        this.name = name;
        running = true;
        this.ticksPerSecond = ticksPerSecond;
    }

    /**
     * Implemented in a pattern, doesn't really matter what it does, just has to set pixel colors
     */
    public abstract void setPixels();

    public void stop() {
        running = false;
    }

    /**
     * runs setPixels() and increments the counter, ticks at ticksPerSecond
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / (double) ticksPerSecond;
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
                delta--;
            }
        }
    }
}

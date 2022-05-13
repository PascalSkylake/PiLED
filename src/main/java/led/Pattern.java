package led;

import net.State;

public abstract class Pattern implements Runnable {
    public State name;
    private boolean running;

    public Pattern(State name) {
        this.name = name;
        running = true;
    }

    public abstract void setPixels();

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / (double) 50;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                setPixels();
                delta--;
            }
        }
    }
}

import led.LEDController;

public class Main {
    public static void main(String[] args) {
        LEDController controller = new LEDController(180);

        /*
        while (true) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream os;
            State test = State.AUTOBLUE;
            Integer out = 12;
            try {
                PacketReceiver receiver = new PacketReceiver();
                strip = new LEDStrip(100);
                Thread t = new Thread(receiver);
                t.start();
                os = new ObjectOutputStream(baos);
                os.writeObject(test);
                PacketSender sender = new PacketSender(baos.toByteArray());
            } catch (Exception e) {
                e.printStackTrace();
            }

            Main lock = new Main();
            synchronized (lock) {
                try {
                    lock.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        PacketReceiver receiver = new PacketReceiver();
        Thread t = new Thread(receiver);
        t.start();
        System.out.println("waiting");

         */

    }
}

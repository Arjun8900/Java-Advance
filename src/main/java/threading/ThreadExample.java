package threading;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread heavy = new Thread(new MultiThreadingThing(1));
        Thread light = new Thread(new MultiThreadingLight(2));
        heavy.start();

        light.start();


        light.join();


    }

}

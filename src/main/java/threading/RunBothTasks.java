package threading;

public class RunBothTasks {
    public static void main(String[] args) throws InterruptedException {
        Thread heavy = new Thread(new HeavyTask(1));
        Thread light = new Thread(new LightTask(2));
        heavy.start();

        light.start();


        light.join();


    }

}

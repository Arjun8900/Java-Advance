package threading;

public class LightTask implements Runnable{
    private final int threadNumber;

    public LightTask(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Sleeping for 5 sec " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending " + name);
    }
}

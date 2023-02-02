package threading;

public class HeavyTask implements Runnable{
    private final int threadNumber;

    public HeavyTask(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Sleeping for 20 sec " + name);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending " + name);
    }
}

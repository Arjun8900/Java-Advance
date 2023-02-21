package function_interface;

public class MainClass {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(Thread.currentThread().getName());
        new Thread(() -> {
            System.out.println("Thread1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done sleep Thread1 " + Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
            System.out.println("Thread2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done sleep Thread2 " + Thread.currentThread().getName());
        }).start();

        System.out.println("Done Main " + Thread.currentThread().getName());
    }
}

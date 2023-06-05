package testThrtead;

public class someThing {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });
        myThread.start();
        Thread.sleep(100);

        System.out.println("321");

    }


}

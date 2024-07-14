package producerconsumer;

public class DriverCode {
    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);


        t2.start();
        t1.start();
    }
}

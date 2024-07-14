package producerconsumer;

public class Consumer extends Thread{

    Producer producer;
    int sum = 0;

    Consumer(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        synchronized (producer.priorityQueue){
            try
            {
                producer.priorityQueue.wait();
                System.out.println("Numbers present in queue are -> " + producer.priorityQueue);
                for (Integer i : producer.priorityQueue){
                    sum = sum + i;
                }
                System.out.println("sum of numbers in queue -> " + sum);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

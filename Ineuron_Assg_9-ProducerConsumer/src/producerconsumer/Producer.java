package producerconsumer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{

    PriorityQueue<Integer> priorityQueue;
    Random random = new Random();

    Producer(){

        priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void run() {

        synchronized (priorityQueue){
            for (int i = 1; i <= 5; i++) {
                try
                {
                    Integer number = random.nextInt();
                    Thread.sleep(100);
                    System.out.println("Generated Random No is : " + number);
                    priorityQueue.add(number);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            priorityQueue.notify();
        }
    }
}

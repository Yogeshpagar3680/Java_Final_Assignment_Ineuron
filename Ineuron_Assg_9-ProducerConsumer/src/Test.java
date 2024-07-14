import java.util.PriorityQueue;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        Random random = new Random();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=1; i<=5; i++){
            Integer number = random.nextInt();
            System.out.println("Random No is :: " + number);
            priorityQueue.add(number);
        }
        for (Integer i : priorityQueue){
            System.out.println("Numbers in queue are -> " + i);
        }
    }
}

/**
 * Created by dongdor on 2016. 7. 14..
 */
public class Test_Queue {

    public static void main(String[] args){

        int dequeue_value;
        ArrayQueue arrayQueue = ArrayQueue.createQueue(5);
        DynArrayQueue dynArrayQueue = DynArrayQueue.createDynArrayQueue();
        LLQueue llQueue = LLQueue.createQueue();


        arrayQueue.enQueue(10);
        arrayQueue.enQueue(11);
        arrayQueue.enQueue(12);
        arrayQueue.enQueue(13);
        arrayQueue.enQueue(14);

        int arrayQ_size = arrayQueue.getQueueSize();
        System.out.println("size of array Queue : "+arrayQ_size);
        dequeue_value = arrayQueue.deQueue();
        System.out.println("you array dequeue : "+dequeue_value);
        dequeue_value = arrayQueue.deQueue();
        System.out.println("you array dequeue : "+dequeue_value);
        dequeue_value = arrayQueue.deQueue();
        System.out.println("you array dequeue : "+dequeue_value);
        dequeue_value = arrayQueue.deQueue();
        System.out.println("you array dequeue : "+dequeue_value);

        dynArrayQueue.enQueue(30);
        dynArrayQueue.enQueue(40);
        dynArrayQueue.enQueue(50);
        dynArrayQueue.enQueue(60);
        dynArrayQueue.enQueue(70);
        dynArrayQueue.enQueue(80);
        dynArrayQueue.enQueue(90);

        int dynQ_size = dynArrayQueue.getQueueSize();
        System.out.println("size of dyn Queue : "+dynQ_size);
        dequeue_value = dynArrayQueue.deQueue();
        System.out.println("you dyn dequeue : "+dequeue_value);
        dequeue_value = dynArrayQueue.deQueue();
        System.out.println("you dyn dequeue : "+dequeue_value);
        dequeue_value = dynArrayQueue.deQueue();
        System.out.println("you dyn dequeue : "+dequeue_value);
        dequeue_value = dynArrayQueue.deQueue();
        System.out.println("you dyn dequeue : "+dequeue_value);

        llQueue.enQueue(100);
        llQueue.enQueue(110);
        llQueue.enQueue(120);
        llQueue.enQueue(130);

        llQueue.enQueue(140);
        llQueue.enQueue(150);
        llQueue.enQueue(160);
        llQueue.enQueue(170);

        llQueue.enQueue(180);
        llQueue.enQueue(190);
        llQueue.enQueue(200);

        int llQ_size = llQueue.getQueueSize(llQueue);
        System.out.println("size of llq Queue : "+llQ_size);
        dequeue_value = llQueue.deQueue();
        System.out.println("you llq dequeue : "+dequeue_value);
        dequeue_value = llQueue.deQueue();
        System.out.println("you llq dequeue : "+dequeue_value);
        dequeue_value = llQueue.deQueue();
        System.out.println("you llq dequeue : "+dequeue_value);
        dequeue_value = llQueue.deQueue();
        System.out.println("you llq dequeue : "+dequeue_value);

    }
}

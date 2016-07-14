/**
 * Created by dongdor on 2016. 7. 14..
 */
public class ArrayQueue {

    private int front;
    private int rear;
    private int capacity;
    private int [] array;

    public ArrayQueue(int size){
        capacity = size;
        front = -1;
        rear = -1;
        array = new int[size];
    }

    public static ArrayQueue createQueue(int size){
        return new ArrayQueue(size);
    }

    public boolean isEmpty(){
        return (front==-1);
    }

    public boolean isFull(){
        // size 가 10일 경우 rear은 9가 된다. front는 기본 0으로 고정이다.
        // 그러므로 9+1 % 10  은 0이 되므로 꽉찼다는 것을 알 수 있다.
        return((rear+1)%capacity == front);
    }

    public int getQueueSize(){
        System.out.println("capacity : "+capacity);
        return ((capacity - front + rear + 1)%capacity);
    }

    //항목을 큐에 삽입
    public void enQueue(int data){
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            System.out.println("front : "+front);
            rear = (rear+1)%capacity;
            System.out.println("rear : "+rear);
            array[rear] = data;
            if(front == -1){
                front = rear;
            }
        }
    }

    //항목을 큐에서 빼내기
    public int deQueue(){
        int data;
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            System.out.println("front : "+front);
            data = array[front];
            if(front == rear){
                front = rear - 1;
            }
            else{
                front = (front+1)%capacity;
            }
        }
        return data;
    }
}

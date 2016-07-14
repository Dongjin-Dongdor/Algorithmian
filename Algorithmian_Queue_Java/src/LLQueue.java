import java.util.EmptyStackException;
import java.util.Queue;

/**
 * Created by dongdor on 2016. 7. 14..
 */
public class LLQueue {

    private class LLNode{

        int data;
        LLNode nextNode;

        private LLNode(int data){
            this.data = data;
            this.nextNode = null;
        }

        private void setNext(LLNode nextNode){
            this.nextNode = nextNode;
        }

        private int getData(){
            return data;
        }

        private LLNode getNext(){
            return this.nextNode;
        }

    }

    private LLNode frontNode;
    private LLNode rearNode;

    public LLQueue(){
        this.frontNode = null;
        this.rearNode = null;
    }

    public static LLQueue createQueue(){
        return new LLQueue();
    }

    public boolean isEmpty(){
        return (frontNode == null);
    }

    public void enQueue(int data){
        LLNode newNode = new LLNode(data);
        if(rearNode != null){
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if(frontNode == null){
            frontNode = rearNode;
        }
    }

    public int deQueue(){
        int data = -1;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }
}

import java.util.EmptyStackException;
import java.util.Stack;

public class LLStack{

    private class LLNode{
        private int data = -1;
        private LLNode nextNode;

        LLNode(int data){
            this.data = data;
            this.nextNode = null;
        }
        private int getData(){
            return data;
        }

        private LLNode getNext(){
            return this.nextNode;
        }

        private void setData(int data){
            this.data = data;
        }

        private void setNext(LLNode nextNode){
            this.nextNode = nextNode;
        }
    }

    private LLNode headNode;

    public LLStack(){
        this.headNode = new LLNode(-1);
    }

    public void Push(int data){
        if(headNode == null){
            headNode = new LLNode(data);
        }
        else if(headNode.getData() == -1){
            headNode.setData(data);
        }
        else{
            LLNode llNode = new LLNode(data);
            llNode.setNext(headNode);
            headNode = llNode;
        }
    }

    public int top(){
        if(headNode == null) return -1;
        else return headNode.getData();
    }

    public int pop(){
        if(headNode == null){
            return -1;
        }
        else{
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty(){
        if(headNode == null) return true;
        else return false;
    }

    public void deleteStack(){
        headNode = null;
    }
}
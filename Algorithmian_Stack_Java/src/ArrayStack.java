/**
 * Created by dongdor on 2016. 7. 13..
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        //참이면 1 거짓이면 0
        return(top== -1);
    }

    public boolean isStackFull(){
        //참이면 1 거짓이면 0
        return(top == capacity-1);
    }

    public void push(int data){
        if(isStackFull()) System.out.println("Stack Overflow");
        else
            array[++top] = data;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is Empty");
            return 0;
        }
        else return (array[top--]);
    }

    public void deleteStack(){
        top = -1;
    }
}

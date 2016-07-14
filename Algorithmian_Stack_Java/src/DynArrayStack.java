/**
 * Created by dongdor on 2016. 7. 14..
 */

/*
두배 확장 기법이다
배열이 가득 차면 크기가 2배인 새 배열을 만들어 항목들을 복사한다
n번의 푸시 연산에 배열 크기를 두 배로 만드는 것을 log n번 수행하면 log n항을 갖는다
n번 푸시 연산의 전체 시간 T(n)은 연산의 횟수에 비례한다

**메모리 오버플로우 예외가 발생할 수 있다
 */
public class DynArrayStack {

    private int top;
    private int capacity;
    private int[] array;
    public DynArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isStackFull(){
        return(top == capacity -1);
    }

    public void push(int data){
        if(isStackFull()){
            doubleStack();
        }
        array[++top] = data;
    }

    private void doubleStack(){
        int newArray[] = new int[capacity*2];
        //System.arraycopy
        //1parameter : 원본
        //2parameter : 원본의 어느 부분부터 읽어올지 결정
        //3parameter : 복사대상
        //4parameter : 복사부분 쓰는 위치
        //5parameter : 원본에서 얼만큼 읽을지 결정
        System.arraycopy(array, 0, newArray,0,capacity);
        capacity = capacity * 2;
        array = newArray;
    }

    public int pop() {
        if (isEmpty()){
            System.out.println("Stack Overflow");
            return array[top];
        }


        else{
            return (array[top--]);
        }
    }

    public void deleteStack(){
        top = -1;
    }

}

/**
 * Created by dongdor on 2016. 7. 11..
 */
public class ArrayStack {

    private int top;
    private int maxSize;
    private Object[] stackArray;

    //배열 스택 생성, 스택의 최대 크기로 생성

    public ArrayStack(int maxSize)
    {
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1; // 탑을 -1로 넣어준다

    }

    //스택이 비어있는지 체크
    public boolean empty()
    {
        return(top == -1);
    }

    //스택이 꽉찼는지 체크
    public boolean full()
    {
        //-1인 이유는 top이 -1부터 시작하니깐 마지막에 한개를 빼주어야한다
        return (top == maxSize-1);
    }

    //스택에 item 입력
    public void push(Object item)
    {
        if(full())
        {
            throw new ArrayIndexOutOfBoundsException((top+1)+">="+maxSize);
        }

        stackArray[++top] = item;

    }

    //스택의 가장 위의 데이터 반환
    public Object peek()
    {
        if(empty())
        {
            throw new ArrayIndexOutOfBoundsException(top);
        }

        return stackArray[top];
    }

    public Object pop()
    {
        Object item = peek();
        top --;
        return item;

    }

}

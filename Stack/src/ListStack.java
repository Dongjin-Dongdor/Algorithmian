/**
 * Created by dongdor on 2016. 7. 11..
 */
public class ListStack {

    private Node top;

    //노드 class 단순연결리스트와 같다.
    private class Node
    {
        private Object data;
        private Node nextNode;

        Node(Object data)
        {
            this.data = data;
            this.nextNode = null;

        }
    }


    //생성자, stack 이 비어있으므로 top은 null이다
    public ListStack()
    {
        this.top = null;
    }

    //스택이 비어있는지 확인
    public boolean empty()
    {
        return(top == null);

    }

    //item 을 스택의 top에 넣는다.
    public void push(Object item)
    {
        Node newNode = new Node(item);
        newNode.nextNode = top;
        top = newNode;
    }

    //top노드의 데이터를 반환한다
    public Object peek()
    {
        if(empty())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return top.data;

    }

    public Object pop()
    {
        Object item = peek();
        top = top.nextNode;
        return item;
    }

}

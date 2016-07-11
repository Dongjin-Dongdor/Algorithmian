/**
 * Created by dongdor on 2016. 7. 11..
 */
public class StackTest {

    public static void main(String[] args)
    {
        //배열리스트 스택 생
        ArrayStack arrayStack = new ArrayStack(5);

        System.out.println("Array Stack 테스트");

        //배열스택에 데이터 삽입

        for(int i=1; i<=5;i++)
        {
            arrayStack.push("ArrayStack데이터-"+i);

        }
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println();


        //연결리스트 스택 생성
        ListStack listStack = new ListStack();

        System.out.println("List Stack 테스트");

        //스택에 데이터 삽입
        for(int i=1; i<=5;i++)
        {
            listStack.push("ListStack 데이터-"+i);
        }

        listStack.push("ListStack 데이터-6");

        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.peek());
        System.out.println(listStack.peek());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());

    }
}

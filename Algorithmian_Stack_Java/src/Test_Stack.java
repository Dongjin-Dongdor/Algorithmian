/**
 * Created by dongdor on 2016. 7. 14..
 */
public class Test_Stack {

    public static void main(String[] args){

        ArrayStack new_stack = new ArrayStack();
        new_stack.push(30);
        new_stack.push(40);



        int value = new_stack.pop();
        System.out.println(value);
    }
}

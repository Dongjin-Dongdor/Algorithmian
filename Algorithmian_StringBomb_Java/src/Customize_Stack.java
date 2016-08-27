/**
 * Created by dongdor on 2016. 8. 28..
 */
public class Customize_Stack {


    private Customize_Node headNode;

    private Customize_Stack(){

        headNode = null;

    }

    public static Customize_Stack createStack(){

        return new Customize_Stack();
    }
    public void push(char data){

        Customize_Node newNode = new Customize_Node(data);
        if(headNode == null){
            headNode = newNode;
        }
        else{
            newNode.setNextNode(headNode);
            headNode = newNode;
        }
    }

    public char pop(){

        char data = 65;
        if(headNode == null){
            return data;
        }
        else{
            data = headNode.getData();
            return data;
        }
    }



}

/**
 * Created by dongdor on 2016. 8. 28..
 */
public class Customize_Node {

    private char data;
    private Customize_Node nextNode;

    public Customize_Node(char data){

        this.data = data;
        nextNode = null;
    }


    public void setNextNode(Customize_Node nextNode){

        this.nextNode = nextNode;
    }

    public Customize_Node getNextNode(){

        return this.nextNode;
    }

    public char getData(){
        return this.data;
    }


}

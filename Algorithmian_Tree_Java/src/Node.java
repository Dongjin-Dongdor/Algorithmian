/**
 * Created by dongdor on 2016. 7. 15..
 */
public class Node {

    private char data;
    private Node leftChild;
    private Node rightSibling;

    public Node(char data){
        this.data = data;
    }

    public void setData(char data){
        this.data = data;
    }

    public char getData(){
        return data;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public void setRightSibling(Node rightSibling){
        this.rightSibling = rightSibling;
    }

    public Node getRightSibling(){
        return rightSibling;
    }


}

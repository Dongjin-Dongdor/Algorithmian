/**
 * Created by dongdor on 2016. 7. 30..
 */
public class BinarySearchNode {

    private int value;
    private BinarySearchNode left;
    private BinarySearchNode right;

    public BinarySearchNode(){

    }

    public BinarySearchNode(int value, BinarySearchNode left,
                            BinarySearchNode right){

        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public BinarySearchNode getLeft(){
        return left;
    }

    public void setLeft(BinarySearchNode left){
        this.left = left;
    }

    public BinarySearchNode getRight(){
        return right;
    }

    public void setRight(BinarySearchNode right){
        this.right = right;
    }
}

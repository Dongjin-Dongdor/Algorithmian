/**
 * Created by dongdor on 2016. 7. 30..
 */

/*
시간 복잡도
O(logN)
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree mTree = new BinarySearchTree();

        mTree.insert(mTree.getRoot(), 5);//root
        mTree.insert(mTree.getRoot(), 1);
        mTree.insert(mTree.getRoot(), 0);
        mTree.insert(mTree.getRoot(), 3);
        mTree.insert(mTree.getRoot(), 7);
        mTree.insert(mTree.getRoot(), 6);
        mTree.insert(mTree.getRoot(), 4);
        mTree.insert(mTree.getRoot(), 2);
        mTree.insert(mTree.getRoot(), 8);


        System.out.println("PreOrderPrintTree");
        PreOrderPrintTree(mTree.getRoot());
        System.out.println("InOrderPrintTree");
        InOrderPrintTree(mTree.getRoot());
        System.out.println("");
        System.out.println("PostOrderPrintTree");
        PostOrderPrintTree(mTree.getRoot());
        System.out.println("");

        System.out.println("Search(4)" + mTree.search(mTree.getRoot(), 4));
        System.out.println("Search(9)" + mTree.search(mTree.getRoot(), 9));
        System.out.println("Search(8)" + mTree.search(mTree.getRoot(), 8));
        System.out.println("Search(-1)" + mTree.search(mTree.getRoot(), -1));

    }
    /*
    전위 순회
     */
    public static void PreOrderPrintTree(BinarySearchNode node){
        if(node == null)
            return;
        System.out.print(" "+node.getValue());
        PreOrderPrintTree(node.getLeft());
        PreOrderPrintTree(node.getRight());
    }

    /*
    중위 순회
     */
    public static void InOrderPrintTree(BinarySearchNode node){
        if(node == null)
            return;
        InOrderPrintTree(node.getLeft());
        System.out.print(" "+node.getValue());
        InOrderPrintTree(node.getRight());

    }

    /*
    후위 순회
     */
    public static void PostOrderPrintTree(BinarySearchNode node){
        if(node == null)
            return;
        PostOrderPrintTree(node.getLeft());
        PostOrderPrintTree(node.getRight());
        System.out.print(" "+node.getValue());
    }
}

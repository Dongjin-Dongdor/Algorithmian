import com.sun.source.tree.BinaryTree;

/**
 * Created by dongdor on 2016. 7. 30..
 */
public class BinarySearchTree {

    private BinarySearchNode root;

    public BinarySearchNode getRoot(){
        return root;
    }

    public void insert(BinarySearchNode node, int insertValue){

        System.out.println(node);
        // 처음 노드를 집어넣었을 경우
        if(node == null){

            root = new BinarySearchNode(insertValue, null,null);
            System.out.print("Register Root Node");
        }

        //현재 노드의 값이 집어넣는 Value보다 클시
        if(node.getValue()> insertValue){
            if(node.getLeft() == null){
                node.setLeft(new BinarySearchNode(insertValue,null,null));
            }
            //만약에 값이 있다면 다시 insert문으로 들어가서 insertValue가 들어가야할 위치를 찾는다
            else{
                insert(node.getLeft(),insertValue);
            }
        }
        else{
            if(node.getRight() == null){
                node.setRight(new BinarySearchNode(insertValue, null, null));
            }
            //만약에 값이 있다면 다시 insert문으로 들어가서 insertValue가 들어가야할 위치를 찾는다
            else{
                insert(node.getRight(),insertValue);
            }
        }
    }

    public boolean search(BinarySearchNode node, int searchValue){
        if(node.getValue() == searchValue){
            return true;
        }
        if(node.getValue()>searchValue && node.getLeft() != null){
            return search(node.getLeft(),searchValue);
        }
        return node.getRight() != null && search(node.getRight(), searchValue);
    }




}

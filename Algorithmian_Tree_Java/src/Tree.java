import com.sun.source.tree.BinaryTree;

/**
 * Created by dongdor on 2016. 7. 15..
 */
public class Tree {

    //부모 노드에 자식 노드 추가
    public static void add(Node parent, Node child){
        //부모 노드의 자식 노드가 없다면
        if(parent.getLeftChild() == null)
            parent.setLeftChild(child);

        //부모 노드의 자식 노드가 있다면
        else{
            Node temp = parent.getLeftChild();
            while(temp.getRightSibling() != null){
                temp = temp.getRightSibling();
            }
            temp.setRightSibling(child);
        }
    }

    //레벨 출력 : 깊이가 같은 노드의 집합
    public static void printLevel(Node node, int level){
        int depth = 0;
        Node tempChild = node;
        Node tempParent = node;

        //레벨에 도달할 때까지 반복
        while(depth <= level){
            if(depth == level){
                //해당 레벨의 노드가 존재한다면
                while(tempChild != null){
                    //데이터를 출력하고 형제노드로 이동한다
                    System.out.print(tempChild.getData()+" ");
                    tempChild = tempChild.getRightSibling();
                }

                //부모 노드의 형제 노드가 존재한다면
                //그 노드의 자식 노드들도 출력해줘야 한다
                if(tempParent.getRightSibling() != null){
                    tempParent = tempParent.getRightSibling();
                    tempChild = tempParent.getLeftChild();
                }
                else
                    break;
            }
            else{
                // 깊이와 레벨이 맞지 않으면 부모 노드를 저장하고
                // 한단계 아래로 내려간다.
                tempParent = tempChild;
                tempChild = tempChild.getLeftChild();
                depth++;
            }
        }
    }


    //모두 출력
    public static void printTree(Node node, int depth){
        for(int i = 0; i<depth; i++)
            System.out.print(" ");
        //데이터 출력
        System.out.println(node.getData());
        //자식노드가 존재한다면
        if(node.getLeftChild() != null)
            printTree(node.getLeftChild(),depth+1);
        //형제 노드가 존재한다면
        if(node.getRightSibling() != null)
            printTree(node.getRightSibling(),depth);
    }
}









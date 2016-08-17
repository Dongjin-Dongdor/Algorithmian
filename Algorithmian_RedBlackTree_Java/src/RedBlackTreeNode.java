import java.awt.*;

/**
 *
 * 레드블랙트리는 이진탐색트리에 균현을 맞추는 기능을 추가한 트리이다
 균형이 안맞는 사향이진트리와 같이 한쪽으로 쏠리다면 성능은 O(n)밖에 나오지 않는다
 따라서 완전이진트리처럼 균현을 맞춰서 트리에 n개의 원소가 있다면 삽입 삭제, 탐색할 때 성능을 O(logN)으로 만들 수 있는 자료구조이다.

 레드블랙트리가 되기 위한 조건
 1) 노드는 레드 혹은 블랙 중의 하나이다
 2) 루트 노드는 블랙이다
 3) 모든 리프노드는 블랙이다
 4) 레드노드의 자식노드 양쪽은 언제나 블랙이다 (즉 레드노드는 연달아 나타날 수 없으며 블랙노드만이 레드 노드의 부모 노드가 될 수 있다)
 5) 어떤 노드로부터 시작되어 리프 노드에 도달하는 모든 경로에는 리프 노드를 제외하면 모두 같은 개수의 블랙 노드가 있다
 */


class RedBlackTreeNode{

    private int value;
    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private RedBlackTreeNode parent;
    private Color color;

    public RedBlackTreeNode grandParent(){// 할아버지 노드
        if(parent != null) // 부모가 있다면 할아버지노드 반환
            return parent.getParent();

        else{
            return null; // 부모 없다면 null 반환
        }
    }

    public RedBlackTreeNode sibling(){ //형제 노드
        if(getParent() != null){ //부모가 있다면 부모의 내가 아닌 자식노드 반환
            if(this == getParent().getLeft()) //Left랑 내가 같다면 나의 형제노드는 Right일 것이다.
                return getParent().getRight();
            else
                return getParent().getLeft();
        }
        else{ // 부모가 없다면 null 반환
            return null;
        }
    }
    public RedBlackTreeNode uncle(){ //삼촌 노드
        return parent.sibling();
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public RedBlackTreeNode getLeft(){
        return left;
    }

    public void setLeft(RedBlackTreeNode left){
        this.left = left;
    }

    public RedBlackTreeNode getRight(){
        return right;
    }

    public void setRight(RedBlackTreeNode right){
        this.right = right;
    }

    public RedBlackTreeNode getParent(){
        return parent;
    }

    public void setParent(RedBlackTreeNode parent){
        this.parent = parent;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }




    /**삽입
    Root노드로 시작한 경우 노드의 Color를 Black으로 바꿔준다
    2번 속성을 만족시켜주기 위한 함수이다
    또한 5번 속성을 만족한다
    Root노드가 아니라면 2번으로 넘어간다
     */
    public void insertCase1(RedBlackTreeNode node){
        if(node.getParent() == null) // root라면
            node.setColor(Color.BLACK); //2번 속성
        else
            insertCase2(node);
    }

    /**
     부모노드의 Color가 Black인 경우 트리는 유효하다
     */

    public void insertCase2(RedBlackTreeNode node){
        if(node.getParent().getColor() == Color.BLACK)//부모의 color가 Black인 경우 4번 속성 만족
            return; //트리가 유효함
        //5번 유효
        else
            insertCase3(node); //부모의 Color가 Red인 경우
    }

    /**
    부모노드의 Color가 Red인 경우 And 삼촌노드의 Color가 Red인 경우 Color를 반전 시켜준다
     부모
     */


}
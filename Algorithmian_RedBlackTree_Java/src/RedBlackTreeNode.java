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
    private RedBlackTreeNode root;
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

    public RedBlackTreeNode root(){
        while(getParent() != null){
            root = getParent().getParent();
        }
        return root;
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
     부모노드와 삼촌노드는 Black 할아버지노드는 Red로 바꿔준다 --> 1번으로 할아버지 노드를 삽입하는 동작으로 간다
    */

    public void insertCase3(RedBlackTreeNode node){
        RedBlackTreeNode uncle = node.uncle();
        RedBlackTreeNode grandParent;

        if((uncle != null) && (uncle.getColor() == Color.RED)) {
            node.getParent().setColor(Color.BLACK);
            uncle.setColor(Color.BLACK);
            grandParent = node.getParent();
            grandParent.setColor(Color.RED);

            insertCase1(grandParent);
        }
        else {
            insertCase4(node);
        }
    }
    /**
     부모노드의 Color가 Red인 경우 And 삼촌노드의 Color가 Red인경우가 아니라면 4번으로 넘어간다
     4~5번은 else가 아니라 동시에 일어난다

     4) 부모노드의 Color가 Red이고 삼촌노드의 Color가 Black인 경우
      4-1 삽입한 노드가 오른쪽 자식이고 부모노드는 왼쪽자식일때 부모노드를 왼쪽회전한다
      4-2 삽입한 노드가 왼쪽 자식이고 부모노드는 오른쪽 자식일때 부모노드를 오른쪽 회전한다

     하지만 5번 속성을 위반하고 있기 떄문에 삽입한 노드의 자식으로 변한 부모노드를 더 처리해주기 위해서
     5번 삽입단계로 넘어간다
     */

    public void insertCase4(RedBlackTreeNode node){
        RedBlackTreeNode grandParent = node.grandParent();

        if( ( node == node.getParent().getRight() ) && (node.getParent() == grandParent.getLeft() ) ){
            rotateLeft(node.getParent()); //왼쪽회전
            node = node.getLeft(); //원래 노드의 부모노드였던 자식노드에 대한 처리를 하기 위해서 부모노드로 주소변경
        }
        else if( ( node == node.getParent() && (node.getParent() == grandParent.getRight()) )){
            rotateRight(node.getParent());
            node = node.getRight();

        }
        insertCase5(node);

    }

    public void rotateLeft(RedBlackTreeNode node){
        RedBlackTreeNode child = node.getRight();
        RedBlackTreeNode parent = node.getParent();

        if(child.getLeft() != null )
            child.getLeft().setParent(node);

        node.setRight(child.getLeft());
        node.setParent(child);
        child.setLeft(node);
        child.setParent(parent);

        if(parent != null){
            if(parent.getLeft() == node)
                parent.setLeft(child);
            else
                parent.setRight(child);

        }
    }

    public void rotateRight(RedBlackTreeNode node){
        RedBlackTreeNode child = node.getLeft();
        RedBlackTreeNode parent = node.getParent();

        if( child.getRight() != null)
            child.getRight().setParent(node);

        node.setLeft(child.getRight());
        node.setParent(child);
        child.setRight(node);
        child.setParent(parent);

        if(parent != null){
            if(parent.getRight() == node)
                parent.setRight(child);
            else
                parent.setLeft(child);
        }
    }

    /**
    부모노드의 Color는 Red이고 삼촌노드의 Color는 Black이고
     삽입한 노드가 오른쪽 자식이고 부모노드는 오른쪽 자식일때 할아버지노드를 왼쪽회전한다

     삽입한 노드가 왼쪽 자식이고 부모노드는 왼쪽자식일때 할아버지노드를 오른쪽 회전한다
     부모노드와 할아버지노드의 Color는 반전시켜준다
     4번을 거쳐온 5번이라면 삽입노드의 부모였던 부모노드가 회전을 통해 삽입노드의 자식이 되었고
     자식이 된 부모노드를 삽입노드라고 생각하고 5번을 진행한다
     4번을 거쳐오지 않은 5번이라면 삽입노드로 바로 생각을 하면된다
     5번 단계를 거치면서 4번을 만족하게 된다
     */
    public void insertCase5(RedBlackTreeNode node){
        RedBlackTreeNode grandParent = node.grandParent();
        node.getParent().setColor(Color.BLACK);
        grandParent.setColor(Color.RED);
        if(node == node.getParent().getLeft()){
            rotateRight(grandParent);
        }else{
            rotateLeft(grandParent);
        }
    }


    ////////////////////////삭제
    /**
     일반적인 이진트리탐색과 같은 삭제 연산을 한다
     삭제되는 노드의 왼쪽 자식노드를 기준으로 계속 오른쪽으로 탐색한 자식 중
     가장 큰 값과 교체를 해주며 중위 순회시 바로 전 값이다
     반대로는 오른쪽 자식노드를 기준으로 계속 왼쪽으로 탐색한 자식 중 가장 작은 값과
     교체를 해주며 중위순회시 바로 다음 값이다
     교체한 노드를 교체 노드라고 하겠다
     삭제한 노드 색깔에 따라 삭제를 처리해준다
     -레드노드는 속성4에 영향을 주지 않기 때문에 괜찮다
     -블랙노드의 삭제는 속성 4에 영향을 주기때문에 균형을 맞춰주어야한다
     ****이제부터 다룰 내용은 삭제를 어떻게 하는지가 아니라 삭제 후 어떻게 균형을 잡아 줄지에 대한 내용이다
     */

    private RedBlackTreeNode searchNode(int value){
        RedBlackTreeNode node = root;
        while(node != null){
            if(node.getValue() == value){
                return node;
            }
            else if(node.getValue()<value){
                node = node.getLeft();
            }
            else{
                node = node.getRight();
            }
        }
        return node;
    }
    private RedBlackTreeNode leftMaximumNode(RedBlackTreeNode node){
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node;
    }

    private void replaceNode(RedBlackTreeNode oldNode, RedBlackTreeNode newNode){
        if(oldNode.getParent()==null){
            root = newNode;
        }
        else{
            if(oldNode == oldNode.getParent().getLeft())
                oldNode.getParent().setLeft(newNode);
            else
                oldNode.getParent().setRight(newNode);
        }
        if(newNode != null){
            newNode.setParent(oldNode.getParent());
        }
    }

    public void delete(int value){
        RedBlackTreeNode node = searchNode(value);
        if(node == null)
            return;
        if(node.getLeft() != null && node.getRight() != null){
            RedBlackTreeNode leftMaxNode = leftMaximumNode(node.getLeft());
            node = leftMaxNode;
        }

        RedBlackTreeNode child = (node.getRight() == null)? node.getLeft() : node.getRight();
        if(node.getColor()== Color.BLACK){
            node.setColor(child.getColor());
            deleteCase1(node);
        }
        replaceNode(node, child);

    }

    /**
     교체노드가 새로운 루트가 될 경우이다
     */
    public void deleteCase1(RedBlackTreeNode node){
        if(node.getParent() != null)
            deleteCase2(node);
    }

    /**
     형제노드가 빨강일 경우 부모노드와 형제노드의 색을 바꾸고 왼쪽으로 회전한다
     */
    public void deleteCase2(RedBlackTreeNode node){
        RedBlackTreeNode sibling = node.sibling();
        if(sibling.getColor() == Color.RED){
            node.getParent().setColor(Color.RED);
            sibling.setColor(Color.BLACK);//형제 Color를 바꿔주고
            if(node == node.getParent().getLeft()){
                rotateLeft(node.getParent()); //왼쪽 자식이면 왼쪽으로 돌려주고
            }
            else{
                rotateRight(node.getParent());
            }
        }
        deleteCase3(node);
    }

    /**
     case 2를 통과하면 N과 S는 반드시 검은색 노드가 된다.
     2)번 이후부터는 P, SL, SR의 경우에 대해서 생각한다
     총 8개의 경우의 수에 대한 처리를 하기 위해서 3~6번까지 작업을 진행한다

     3)부모노드(P), 형제노드(S),형제노드의 자식(SL, SR)이 모두 검은색이라면 형제 노드(S)를 빨강으로 바꿔준다
     */
    // 즉 (P, SL, SR) = (검, 검, 검) 이라면 Case3에서 해결
    public void deleteCase3(RedBlackTreeNode node){
        RedBlackTreeNode sibling = node.sibling();
        if ((node.getParent().getColor() == Color.BLACK)
                && (sibling.getColor() == Color.BLACK)
                && (sibling.getLeft().getColor() == Color.BLACK)
                && (sibling.getRight().getColor() == Color.BLACK)
                ) {
            sibling.setColor(Color.RED);
            deleteCase1(node.getParent());
        }
        else
            deleteCase4(node);
    }

    //(P, SL, SR) = (빨, 검 검) - Case 4에서 해결
    public void deleteCase4(RedBlackTreeNode node){
        RedBlackTreeNode sibling = node.sibling();
        if((node.getParent().getColor() == Color.RED)
                && (sibling.getColor() == Color.BLACK)
                && (sibling.getLeft().getColor() == Color.BLACK)
                && (sibling.getRight().getColor() == Color.BLACK)) {
            sibling.setColor(Color.RED);
            node.getParent().setColor(Color.BLACK);
        }
        else
            deleteCase5(node);
    }

    /**
     형제노드가 검정 형제노드의 왼쪽자식이 빨강 형제노드의 오른쪽 자식이 검정이며
     교체노드가 부모의 왼쪽 자식이면 형제노드를 오른쪽으로 회전시켜서 형제노드의 왼쪽자식이 교체노드의 형제노드가
     되도록 만든다
     */

    //(P, SL, SR) = (검, 빨 검) - Case5에서 해결,,,, (P, SL, SR) = (빨, 빨 검) - Case5에서 해결
    public void deleteCase5(RedBlackTreeNode node){
        RedBlackTreeNode sibling = node.sibling();
        if(sibling.getColor() == Color.BLACK){
            if((node == node.getParent().getLeft())
                    && (sibling.getRight().getColor() == Color.BLACK)
                    && (sibling.getLeft().getColor() == Color.RED)){
                sibling.setColor(Color.RED);
                sibling.getLeft().setColor(Color.BLACK);
                rotateRight(sibling);
            }
            else if((node == node.getParent().getRight())
                    && (sibling.getLeft().getColor() == Color.BLACK)
                    && (sibling.getRight().getColor() == Color.RED)){
                sibling.setColor(Color.RED);
                sibling.getRight().setColor(Color.BLACK);
                rotateLeft(sibling);
            }
        }

        deleteCase6(node);
    }

    /**
     6)형제노드가 검은색, 형제노드의 오른쪽 자식이 빨간색이고 교체노드가 부모노드의 왼쪽 자식일때
     부모노드를 회전해서 형제노드가 부모노드와 형제노드의 오른쪽 자식노드의 부모노드가 되게한다

     그리고 부모노드, 형제노드의 색을 바꾸고 형제노드의 오른쪽 자식노드를 검은색으로 한다
     회전하기 전과 마찬가지로 여전히 같은 색을 띄기 때문에 속성4와 속성5가 위배되지 않는다.
     */

    public void deleteCase6(RedBlackTreeNode node){
        RedBlackTreeNode sibling = node.sibling();
        sibling.setColor(node.getParent().getColor());
        node.getParent().setColor(Color.BLACK);

        if(node == node.getParent().getLeft()){
            sibling.getRight().setColor(Color.BLACK);
            rotateLeft(node.getParent());
        }
        else{
            sibling.getLeft().setColor(Color.BLACK);
            rotateRight(node.getParent());
        }
    }
}
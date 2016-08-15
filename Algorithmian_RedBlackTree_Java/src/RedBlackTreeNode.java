/**
 * Created by dongdor on 2016. 8. 15..
 */
class RedBlackTreeNode {
        private int value;
        private RedBlackTreeNode left;
        private RedBlackTreeNode right;
        private RedBlackTreeNode parent;
        private Color color;
      
                public RedBlackTreeNode grandParent() { // 할아버지 노드
                if (parent != null) // 부모가 있다면 할아버지노드 반환
                    return parent.getParent();
                else {
                        return null; // 부모 없다면 null 반환
                    }
            }
      
                public RedBlackTreeNode sibling() { // 형제 노드
                if (getParent() != null) { // 부모가 있다면 부모의 내가아닌 자식노드 반환
                        if (this == getParent().getLeft())
                            return getParent().getRight();
                        else
                            return getParent().getLeft();
                    } else { // 부모 없다면 null 반환
                        return null;
                    }
            }
      
                public RedBlackTreeNode uncle() { // 삼촌노드
                return parent.sibling(); // 부모의 형제노드
            }
      
                public int getValue() {
                return value;
            }
      
                public void setValue(int value) {
                this.value = value;
            }
      
                public RedBlackTreeNode getLeft() {
                return left;
            }
      
                public void setLeft(RedBlackTreeNode left) {
                this.left = left;
            }
      
                public RedBlackTreeNode getRight() {
                return right;
            }
      
                public void setRight(RedBlackTreeNode right) {
                this.right = right;
            }
      
                public RedBlackTreeNode getParent() {
                return parent;
            }
      
                public void setParent(RedBlackTreeNode parent) {
                this.parent = parent;
            }
      
                public Color getColor() {
                return color;
            }
      
                public void setColor(Color color) {
                this.color = color;
            }
}
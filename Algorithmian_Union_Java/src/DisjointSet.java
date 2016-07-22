/**
 * Created by dongdor on 2016. 7. 20..
 */
public class DisjointSet {
    private DisjointNode root;

    public DisjointNode getRoot(){
        return root;
    }

    public void addNode(DisjointNode node){
        if(root == null)
            root = node;
        else
            node.setParent(root);
    }

}

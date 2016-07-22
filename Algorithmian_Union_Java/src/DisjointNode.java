/**
 * Created by dongdor on 2016. 7. 22..
 */
public class DisjointNode {
    private int data;
    private DisjointNode parent;

    public DisjointNode(int data){
        this.data = data;
    }

    public DisjointNode(int daat, DisjointNode parent){
        this.data = data;
        this.parent = parent;
    }

    public int getData(){
        return data;
    }

    public void setDate(int data){
        this.data = data;
    }

    public DisjointNode getParent(){
        return parent;
    }

    public void setParent(DisjointNode parent){
        this.parent = parent;
    }

    @Override
    public String toString(){
        return ""+getData();
    }
}

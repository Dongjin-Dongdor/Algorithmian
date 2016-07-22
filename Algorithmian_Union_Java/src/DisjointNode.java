/**
 * Created by dongdor on 2016. 7. 22..
 */


/*
분리집합 노드 클래스
 */
public class DisjointNode {
    private int data;
    private DisjointNode parent;

    /*
    분리집합 노드 생성
     */
    public DisjointNode(int data){
        this.data = data;
    }


    public DisjointNode(int data, DisjointNode parent){
        this.data = data;
        this.parent = parent;
    }

    //data 반환
    public int getData(){
        return data;
    }

    //data 설정
    public void setDate(int data){
        this.data = data;
    }

    //parent 반환
    public DisjointNode getParent(){
        return parent;
    }

    //parent 설정
    public void setParent(DisjointNode parent){
        this.parent = parent;
    }


    @Override
    public String toString(){
        return ""+getData();
    }
}

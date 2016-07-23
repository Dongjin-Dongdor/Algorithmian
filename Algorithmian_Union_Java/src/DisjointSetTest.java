/**
 * Created by dongdor on 2016. 7. 22..
 */
public class DisjointSetTest {

    public static void main(String[] args){

        DisjointNode three = new DisjointNode(3);
        DisjointNode seven = new DisjointNode(7);
        DisjointNode five = new DisjointNode(5);
        DisjointNode four = new DisjointNode(4);

        DisjointSet setA = new DisjointSet();

        setA.addNode(three);
        setA.addNode(seven);
        setA.addNode(five);
        setA.addNode(four);

        System.out.println("Three Parent : "+three.getParent());
        System.out.println("Seven Parent : "+seven.getParent());
        System.out.println("Five Parent : "+five.getParent());
        System.out.println("Four Parent : "+four.getParent());

        System.out.println("");

        DisjointNode one = new DisjointNode(1);
        DisjointNode two = new DisjointNode(2);
        DisjointNode eight = new DisjointNode(8);
        DisjointNode nine = new DisjointNode(9);

        DisjointSet setB = new DisjointSet();

        setB.addNode(one);
        setB.addNode(two);
        setB.addNode(eight);
        setB.addNode(nine);

        System.out.println("One Parent : "+one.getParent());
        System.out.println("Two Parent : "+two.getParent());
        System.out.println("Eight Parent : "+eight.getParent());
        System.out.println("Nine Parent : "+nine.getParent());


        System.out.println("");

        System.out.println("Three Find Set : "+find(three));
        System.out.println("Five Find Set : "+find(five));

        System.out.println("One Find Set : "+find(one));
        System.out.println("Two Find Set : "+find(two));

        union(setA,setB);

        System.out.println("After Union One Find Set : "+find(one));
        System.out.println("After Union Two Find Set : "+find(two));
    }

    public static DisjointNode find(DisjointNode node){
        DisjointNode temp = node;

        while(temp.getParent() != null){
            temp = temp.getParent();
        }

        return temp;
    }

    public static void union(DisjointSet leftSet, DisjointSet rightSet){
        //leftSet과 rightSet이 null이 아니면 rightSet의 루트의 parent를 leftSet의 root로 setting 한다
        if(leftSet != null && rightSet != null)
            rightSet.getRoot().setParent(leftSet.getRoot());
    }

}

/**
 * Created by dongdor on 2016. 7. 20..
 */
public class DisjointSet {
    public int[] S;
    public int size;//집합의 요소 수


    //MakeSet
    public void MAKESET(int size) {
        S = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            S[i] = i;
        }
    }

    //Find parent
    public int sFIND(int X){
        if(S[X] == X){
            return X;
        }
        else
            return sFIND(S[X]);
    }

    //Union
    public void sUNION(int root1, int root2){
        if(sFIND(root1) == sFIND(root2))
            return;

        if(!((root1 >= 0 && root1 < size) && (root1 >= 0 && root1 < size)))
            return;

        S[root1] = root2;
    }



}

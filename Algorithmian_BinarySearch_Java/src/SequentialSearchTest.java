/**
 * Created by dongdor on 2016. 8. 2..
 */

/**
 * 순차탐색
 * 배열이 있다면 배열의 처음부터 끝까지 차례로 비교하면서 원하는 데이터를 찾는 알고리즘이다
 * 배열이 N개의 경우 최선의 경우는 1번에 찾는 방법이다
 * 최악의 경우는 n번에 찾는 방법
 * 평균은 O(n)이다
 */
public class SequentialSearchTest {
    public static void main(String[] args){
        int[] mArray = {1,2,3,4,5,6,7,8};

        System.out.println("Search(3)"+sequentialSearch(mArray,3));
        System.out.println("Search(9)"+sequentialSearch(mArray,9));
    }

    public static boolean sequentialSearch(int[] inputs, int search){
        boolean isExist = false;
        for(int i = 0; i<inputs.length;i++){
            if(search == inputs[i]){
                isExist = true;
                break;
            }
        }
        return isExist;
    }

}

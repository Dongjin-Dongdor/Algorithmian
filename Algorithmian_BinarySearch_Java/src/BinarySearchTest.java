/**
 * Created by dongdor on 2016. 8. 2..
 */

/**
 * 중앙 값으로 비교를 진행하고 비교할 때마다 중앙값보다 값이 크면 중앙값을 기준으로 오른쪽으로 범위를 1/2하고, 작다면 왼쪽으로 범위를 1/2씩 줄인다
 *
 * 성능 :
 * 배열의 크기가 n이고 가운데 값을 k번 비교한다고 했을 때
 * n * (1/2)^k  = 1
 * k = lnN
 * 시간 복잡도 O(logN)
 */
public class BinarySearchTest {

    public static void main(String[] args){
        int[] mArray = {1,2,3,4,5,6,7,8};

        System.out.println("Search(3)"+binarySearch(mArray,3));
        System.out.println("Search(9)"+binarySearch(mArray,9));
    }


    public static boolean binarySearch(int[] inputs, int search){
        boolean isExist = false;
        int left = 0;
        int right = inputs.length -1;
        while(left<=right){
            int middle = (left+right)/2;
            if(inputs[middle]>search)
                right = middle - 1;//찾는 값이 중앙값보다 작다면
            else if(inputs[middle]<search)
                left = middle + 1;//찾는 값이 중앙값보다 크다면
            else{//찾는 값이 중앙값과 같다면
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}

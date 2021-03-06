/**
 * Created by dongdor on 2016. 7. 27..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
퀵 셀렉트는 N개의 원소를 정렬하는 것이 아니라 K 번재 숫자만 알고싶은 경우에 사용하는 방법이다

N개의 원소 중 K번째 숫자를 찾으라고 하면 보틍은 정렬을 해서 원소를 찾는 방법을 선택할 것이다
하지만 정렬 방법에 따라 성능이 다를 수 있다
퀵 셀렉트를 적용한다면 O(n)의 성능을 얻을 수 있다

퀵 셀렉트의 가장 중요한 부분은 Partition이다
우선 파티션은 먼저 피벗을 뽑느다
그 후 피벗보다 작은 것은 왼쪽 피벗보다 큰 것은 오른쪽으로 정렬하고 피벗을 반환한다

만약 K == Pivot index라면 우리는 K번째 작은 값을 찾은 것이다
 따라서 Pivot index의 리스트 값을 리턴한다

 K < Pivot index 이면 K번째 작은 값은 피벗보다 왼쪽편이다. 그렇기 때문에 right값을 -1해준다

 K > Pivot index 이면 K번째 작은 값은 피벗보다 오른쪽이다 그렇기 때문에 left값을 +1해준다
 */
public class QuickSelectTest {

    /*
    BufferedReader/ BufferedWriter
    : 문자 입력 스트림으로부터 문자를 읽어 들이거나 문자 출력 스트림으로 문자를 내보낼 때 버퍼링을 함으로써
    문자 문자 배열, 문자열 라인 등을 보다 효율적으로 처리할 수 있도록 해준다
    */
    public static void main(String[] args) throws IOException{
        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));

        //조건을 입력 받는다
        String[] inputConditions = bfReader.readLine().split(" ");\
        //0 은 배열 개수 , 1은 K번째 수
        int resultIndex = Integer.parseInt(inputConditions[1]);

        //String 배열에 입력한 값 추가
        String[] inputs = bfReader.readLine().split(" ");

        //StringArrayToIntArray : 기존의 String을 Int로 변환
        // QuickSelect에 intArray와 K번째 위치 인자값으로 전달
        System.out.println(quickSelect(stringArrayToIntArray(inputs), resultIndex -1));
    }

    private static Integer quickSelect(int[] array, int k){

        int left = 0;
        int right = array.length - 1;
        Random rand = new Random();
        while(right >= left){
            int pivotIndex = partition(array, left, right,
                    rand.nextInt(right-left+1)+left);
            if(pivotIndex == k){
                return array[pivotIndex];
            }else if(pivotIndex<k){
                left = pivotIndex + 1;
            }else if(pivotIndex>k){
                right = pivotIndex - 1;
            }

        }
        return null;
    }

    private static int partition(int[] array, int left, int right, int pivot){
        int pivotVal = array[pivot];
        swap(array, pivot, right);
        int storeIndex = left;
        for(int i = left; i<right;i++){
            if(array[i]<pivotVal){
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex);
        return storeIndex;
    }

    public static void swap(int[] array, int index1, int index2){

        int temp  = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    private static int[] stringArrayToIntArray(String[] inputs){
        int[] outputs = new int[inputs.length];
        for(int i = 0; i< inputs.length; i++){
            outputs[i] = Integer.parseInt(inputs[i]);
        }
        return outputs;
    }
}

/**
 *
 */



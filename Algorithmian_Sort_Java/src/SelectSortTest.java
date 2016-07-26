/**
 * Created by dongdor on 2016. 7. 23..
 */


/*
선택정렬
1. 주어진 리스트 중에 최솟값을 찾는다
2. 그 값을 맨 앞에 위치한 값과 교체한다.
3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다
평균 최악 모두 수행시간은 O(n^2)
 */
public class SelectSortTest {
    public static void main(String[] args){
        int inputArray[] = {4,6,7,1,3,18,16,15,15,20,9};
        System.out.println("Before Sort : PrintArray()");
        printArray(inputArray);
        selectSort(inputArray);
        System.out.println("Alter Sort Select : PrintArray()");
        printArray(inputArray);
    }

    public static void selectSort(int[] input){

        for(int i=0; i<input.length -1 ;i++){
            int temp  = i;
            for(int j = i+1; j<input.length ; j++){
                if(input[temp]>input[j]){
                    temp = j;
                }
            }
            swap(input,i,temp);

        }
    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
    public static final void printArray(int[] array){
        for(int element:array){
            System.out.print(element+" ");
        }
        System.out.println(" ");
    }
}



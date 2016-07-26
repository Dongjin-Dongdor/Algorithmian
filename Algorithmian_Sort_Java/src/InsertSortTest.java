/**
 * Created by dongdor on 2016. 7. 26..
 */
/*
삽입 정렬은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 부분과 비교하여
자신의 위치를 찾아 삽입함으로서 정렬을 완성하는 알고르짐이다

최악 수행시간은 O(n^2)이다.
 */
public class InsertSortTest {

    public static void main(String[] args){
        int inputArray[] = {4,6,7,1,3,18,16,15,15,20,9};
        System.out.println("Before Sort : PrintArray()");
        printArray(inputArray);
        insertSort(inputArray);
        System.out.println("Alter Sort Insert: PrintArray()");
        printArray(inputArray);
    }

    public static final void insertSort(int[] array){
        int j;
        for(int i =1; i<array.length;i++){
            int insert = array[i];
            for(j=i-1; j>=0; j--){
                //현재 j가 0이고 i는 1이다
                if(insert<array[j]){
                    //0인 j가 더 클경우 j를 i(1)의 자리로 옮긴다.
                    array[j+1] = array[j];
                }
                else{
                    //break을 하는 이유는 i의 앞자리까지만 정렬하기 위함이다.
                    break;
                }
            }
                array[j+1] = insert;
        }
    }

    public static final void printArray(int[] array){
        for(int element:array){

            System.out.print(element+" ");

        }
        System.out.println(" ");
    }
}

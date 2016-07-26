/**
 * Created by dongdor on 2016. 7. 26..
 */

/*
분할 정복 알고리즘 중의 하나이다
퀵이라는 이름에서 알수 있듯이 평균적인 상황에서 최고의 성능을 나타낸다
1. 리스트 가운데서 하나의 원소를 고른다. 이 원소를 Pivot이라고 한다
2. Pivot앞에는 Pivot보다 값이 작은 모든 원소들이 오고 Pivot뒤에는 Pivot보다
    값이 큰 원소들이 오도록 Pivot을 기준으로 리스트를 둘로 나눈다
    Pivot은 움직이지 않고 두개의 리스트에 대해서 재귀적으로 위의 작업을 반복한다.
    재귀호출이 한번 진행될 때마다 최소한 하나의 원소는 최종적으로 위치가 정해진다
    평균수행시간 O(nlogn)
    최악수행시간 O(n^2)

    퀵정렬이 병합정렬보다 최악의 경우는 더 느릴 수 있지만, 최악의 경우가 될 확률이 적다
 */
public class QuickSortTest {

    public static void main(String[] args){
        int inputArray[] = {4,6,7,1,3,18,16,15,15,20,9};

        System.out.println("Before Sort : PrintArray()");
        printArray(inputArray);
        quickSortPivotZero(inputArray,0,inputArray.length-1);
        System.out.println("Alter Sort : PrintArray()");
        printArray(inputArray);
    }

    public static void quickSortPivotZero(int[] array, int left, int right){
        if(left<right){
            int pivot = array[left];
            int i = left;
            int j = right;

            while(i < j){
                while(array[j] > pivot)
                    j--;
                while(i<j && array[i]<= pivot)
                    i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

            array[left] = array[i];
            array[i] = pivot;

            quickSortPivotZero(array,left,i-1);
            quickSortPivotZero(array,i+1,right);
        }
    }

    public static final void printArray(int array[]){
        for(int element:array){
            System.out.print(element + " ");
        }
        System.out.println("");
    }
}

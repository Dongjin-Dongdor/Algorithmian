/**
 * Created by dongdor on 2016. 7. 26..
 */

/*
병합정렬
분할정복알고리즘은 그대로 해결할 수 없는 문제를 작은 문제로 분할하여 문제를 해결하는 방법이나 알고리즘이다

1. 리스트의 길이가 0또는 1이면 이미 정렬된 것으로 본다
   그렇지 않은 경우에는 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다

2. 각 부부 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다
3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다

평균 최악 모두 수행시간은 :O(nlogn)이다

 */
public class MergeSortTest {

    public static void main(String[] args){
        int inputArray[] = {4,6,7,1,3,18,16,15,15,20,9};
        System.out.println("Before Sort : PrintArray()");
        printArray(inputArray);
        mergeSort(inputArray,0,inputArray.length-1);
        System.out.println("Alter Sort : PrintArray()");
        printArray(inputArray);
    }

    public static void mergeSort(int[] array,int low, int high){
        if(low<high){
            int middle = (low+high)/2;
            System.out.println("low 1 : "+low);
            System.out.println("middle 1 : "+middle);
            //middle이 0이면 첫번째 mergeSort를 탈출한다.
            //그때 low : 0 / middle : 0 / high : 1 이다
            mergeSort(array,low,middle);

            System.out.println("middle 2 : "+middle);
            System.out.println("high 2 : "+high);
            //
            mergeSort(array,middle+1,high);
            System.out.println("low 3 : "+low);
            System.out.println("middle 3 : "+middle);
            System.out.println("high 3 : "+high);
            merge(array,low,middle,high);
        }
    }

    public static void merge(int[] array, int low, int middle, int high){
        int[] helper = new int[array.length];

        for(int i = low; i<= high; i++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remain = middle - helperLeft;
        for(int i = 0; i<remain; i++){
            array[current+i] = helper[helperLeft + i];
        }
    }


    public static final void printArray(int[] array){
        for(int element: array){
            System.out.print(element+" ");
        }
        System.out.println("");
    }

}




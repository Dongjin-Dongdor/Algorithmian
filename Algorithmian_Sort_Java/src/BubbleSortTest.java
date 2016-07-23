/**
 * Created by dongdor on 2016. 7. 23..
 */

/*
코드는 짧고 간결하지만 대부분의 경우에 최악의 상황을 보여준다
수행시간은 O(n^2)이다

 */
public class BubbleSortTest {
    public static void main(String[] args){


    }

    /*
    final변수선언
    final 변수선언는 상속불가 또는 변할수 없는 상수 선언에 사용된다
    final로 선언된 변수는 값을 초기화만 할 수 있고 그 값의 변경 및 새로운 할당이 불가능한 상수가 된다

    final클래스
    클래스에 final을 사용하게 되면 상속불가클래스를 의미한다
    final과 abstract를 함께 사용할수 없다.
    final은 상속 불가를 나타내는데 abstract는 추상 클래스를 생성할 때 사용하는 내용이므로 서로 배타적이 된다

    final메소드
     */
    //
    //static 은 공용의 변수를 만들 때 사용되는 예약어
    public static final void bubbleSort(int input[]){
        for(int i = 0; i<input.length-1;i++){
            for(int j = 0; j<input.length-i-1;j++){
                if(input[j]>input[j+1])
                    swap(input,j,j+1);
            }
        }
    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

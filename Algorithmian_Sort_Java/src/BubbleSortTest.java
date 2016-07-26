/**
 * Created by dongdor on 2016. 7. 23..
 */

/*
코드는 짧고 간결하지만 대부분의 경우에 최악의 상황을 보여준다
수행시간은 O(n^2)이다

 */
public class BubbleSortTest {
    public static void main(String[] args){
        int inputArray[] = {4,6,7,1,3,18,16,15,15,20,9};
        System.out.println("Before Sort : PrintArray()");
        printArray(inputArray);
        bubbleSort(inputArray);
        System.out.println("Alter Sort Bubble: PrintArray()");
        printArray(inputArray);

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
    메소드에 final을 선언하게 되면 그 메소드가 포함 클레스를 상속받은 클래스에서 오라이딩으로 재정의 할 수 없는 메소드.
     */
    //
    /*
    static 변수(정적변수)
    static이 붙은 변수는 클래스의 모든 객체가 공유할 수 있다

    static 메소드(정적변수)
    인스턴스 생성없이 호출 가능하다
     */
    //static 은 공용의 변수를 만들 때 사용되는 예약어

    public static final void bubbleSort(int[] input){
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

    public static final void printArray(int[] array){
        for(int element:array){
            System.out.print(element+" ");
        }
        System.out.println(" ");
    }
}

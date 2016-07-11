import java.util.LinkedList;
import java.util.List;

/**
 * Created by dongdor on 2016. 7. 11..
 */
public class Test_Sort {

    /*
    버블 정렬
    가장 비효율적인 빅오 N제곱이 나올 수 있다
     */

    public int[] bubbleSort(int[] numbers)
    {
        boolean numbersSwitched;
        do
        {

            numbersSwitched = false; // 만일 for 문안에서 더이상 바뀔 숫자가 없다면 false로 남을것이고 while문에서 탈출하게 된다.
            System.out.println("!!!!!!"+numbers.length);
            for(int i =0; i<numbers.length-1;i++)
            {

                if(numbers[i]<numbers[i+1])
                {
                    int tmp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true; // 바뀔경우 true로 바꿔준다
                }
            }
            System.out.println("result"+numbers);

        }
        while(numbersSwitched);

        return numbers;
    }

    /*
    삽입 정렬
     */
    public int[] insertSort(int[] numbers)
    {
        int i, j,key;

        //2번째부터이므로 1부터 시작한다.
        for(i=1; i<numbers.length;i++)
        {
            key = numbers[i];
            for(j = i -1; j>=0&&numbers[j]>key;j--)
            {
                numbers[j+1] = numbers[j];
            }
            numbers[j+1] = key;

        }
        return numbers;
    }



    /*
    퀵 정렬
     */

    public int[] quickDivide(int left, int right, int pivot,int[] numbers)
    {
        if(numbers[left] == numbers[right])
        {
            return numbers;
        }
        else
        {
            if(numbers[left]>numbers[pivot])
            {
                //right가 pivot보다 크다면
                if(numbers[right]>numbers[pivot])
                {
                    right = right - 1;
                    quickDivide(left, right, pivot,numbers);
                }
                //right가 pivot보다 작다면
                else
                {
                    int tmp;
                    tmp = numbers[left];
                    numbers[left] = numbers[right];
                    numbers[right] = tmp;
                    left = left + 1;
                    quickDivide(left,right,pivot,numbers);
                }
            }
        }
        return numbers;
    }

    public int[] quickSort(int[] numbers)
    {
        int left = 0;
        int right = numbers.length-1;
        int pivot = numbers[(numbers.length)/2];
        numbers = quickDivide(left,right,pivot,numbers);

        return numbers;

    }



    public static void main(String[] args) {

        int[] test_list1 = {4, 1, 3, 5, 2};
        int[] result_list;

        Test_Sort sort = new Test_Sort();
        result_list = sort.insertSort(test_list1);
        for(Integer num:result_list)
        {
            System.out.println("insert_result_list : " + num);
        }

        int[] test_list2 = {3,4,2,1,5};
        result_list = sort.bubbleSort(test_list2);
        for(Integer num:result_list)
        {
            System.out.println("bubble_result_list : " + num);
        }

        int[] test_list3 = {3,4,2,1,5};
        result_list = sort.quickSort(test_list3);
        for(Integer num:result_list)
        {
            System.out.println("quick_result_list : " + num);
        }

    }





}

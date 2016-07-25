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
        System.out.println("Before Sort: PrintArray()");
        printArray(inputArray);
        selectSort(inputArray);
        System.out.println("Alter Sort: PrintArray()");
        printArray(inputArray);
    }

    public static void selectSort(int input[]){

    }

    public static final void printArray(int array[]){
        for(int element:array){

        }
    }
}


/*
문제수 30문제
알고리즘/네트워크/데이터이베이스/운영체제/

1. 와이어샤크
    와이어샤크로 봤을 때 TCP/IP분석

2. Javascript관련 특징

3. 알고리즘 quick sort 채워놓기

4. SQL 보기처럼 작성하시오

5. 정규화 순서 (도부이결다조)

6. HTTP error가 의미하는 것

7. 스케줄링과 페이징 기법 --> 타임테이블을 주고 방식을 대입했을 때 결과는?

8. 교착상태와 관련된 것들

9. 

 */

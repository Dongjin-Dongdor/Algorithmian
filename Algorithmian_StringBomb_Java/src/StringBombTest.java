/**
 * Created by dongdor on 2016. 8. 27..
 */




/**
 * 문자열 폭발 문제

 상근이는 문자열에 폭발문자열을 심어 놓았다 폭발문자열이 폭발하면 그 문자는 문자열에서 사라지며 남은 문자열은 합쳐지게 된다
 폭발은 다음과 같은 과정으로 진행된다

 1) 문자열이 폭발 문자열을 포함하고 있는 경우에 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다
 2) 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다
 3) 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다

 입력 : 첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 1000000보다 작거나 같다
       둘째 줄에 폭발 문자열이 주어진다 길이는 1보다 크거나 같고 36보다 작거나 같다
       두 문자열은 모두 알파뱃과 소문자와 대문자 숫자 0 1...9로만 이루어져 있다

 출력 : 첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다


 예제입력 mirkovC4nizCC44
        C4

 예제출력 mirkovniz

 어떻게 풀까
 1) 문자열과 폭발 문자열을 받을 변수를 만든다
 2) 문자열을 char배열에 담는다
 3) 문자열을 Stack에 넣는다. 하나씩 빼가면서 비교하고 만약 Bomb문자열과 같으면 삭제한다
 */

import java.util.Scanner;
import java.util.Stack;

public class StringBombTest {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        char[] stringBuffuer = sc.nextLine().toCharArray();
        char[] stringBomb = sc.nextLine().toCharArray();

    }

    public static Stack<Character> BombAlgorithm(char[] stringBuffer, char[] stringBomb){

        Stack<Character> stringStack = new Stack<Character>();
        
        for(int i = 0; i<stringBuffer.length;i++){

            stringStack.push(stringBuffer[i]);
        }




    }




}

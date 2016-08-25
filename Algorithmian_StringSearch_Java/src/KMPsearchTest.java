/**
 * Created by dongdor on 2016. 8. 20..
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
/**
 1. 일반적인 검색
 - 본문 문자열을 일일히 비교하는 방식

 2. 카프-라빈 알고리즘
 - 문자열 검색을 해시를 사용해서 구함
 검색 패턴값의 해시값과 분문안의 하위 문자열의 해시 값을 비교

 3. KMP 알고리즘
 - 본문 내의 문자열을 한차례 비교하고 나면 다음 단계의 검색에서 사용할 수 있는 '어떤 정보'를 이용해서 불필요한 비교를 피하는 방법이다
    1) prefix(접두부), suffix(접미부) 정의
        패턴을 찾는 것은 Prefix == Suffix 가 같은 지점을 찾는 것이라고 할 수 있다
        ex) ABC  =/= AC
            ABC  === ABC

    2) 최대 경계 너비 배열
        최대 경계 너비  :  일치하는 부분 중 Prefix == Suffix 가 될 수 있는 부분 문자열 중 가장 긴 것의 길이이다
        (첫번째 문자는 -1 , 비교할 것이 없기 때문에)

    3) KMP 알고리즘
    문자열  : [A] [B] [C] [D] [A] [C] [B] [A] [B] [B] [A] [C]
    일치길이 : 0   1   2   3   4   5   6   7   8   9   10  11  12
    패턴문자열:[A] [B] [C] [D] [A] [B] [C]
    최대경계넢: -1  0   0   0   0   1   2

    일치길이가 5인 부분에서 틀렸다
    ABCDA까지만 일치하고 5에서 틀렸다고 말할 수 있다
    이때 최대 경계 너비는 틀린 부분의 문자 이전의 문자열이 ABCDA에서 prefix == suffix가 될 수 있는 부분문자열 중 가장 긴 것의 길이를 저장한 배열이다
    그렇기 때문에 1이다

    이동하는 공식은 일치길이 - 최대경계너비이다 따라서 4 = 5 - 1이다.
    그렇기 때문에 4만큼 이동하게 된다

 */


public class KMPsearchTest {

    public static void main(String[] args) throws IOException{


        Scanner sc = new Scanner(System.in);
        //**깜짝 자바 기초교실 **
        // Scanner 클래스의 next()와 nextLine()메서드의 차이
        //next()메소드의 경우 첫 단어 앞쪽 공백이나 개행문자는 무시하고 하나의 단어를 입력받고
        //단어뒤의 개행문자는 그대로 놔둔다
        //nextLine()메소드의 경우 개행문자까지를 한줄로 인식하고 입력을 받고 \n는 버려진다
        char[] T = sc.nextLine().toCharArray(); // 검색할 문자열
        char[] P = sc.nextLine().toCharArray(); // 검색 패턴

        List result = kmpSearch(T,P);
        System.out.println(result.size());
        for(Object o : result){
            System.out.print(o + " ");
        }

    }

    //P는 검색할 패턴이다
    public static int[] getMaxBoundaryWidthArray(char[] P){ //검색할 패턴을 인자로 보내준다
        int[] maxBoundaryWidthArray = new int[ P.length + 1];  //마지막 최대너비까지 구해준다
        for(int i = 0; i <= P.length; i++){
            if(i == 0){
                maxBoundaryWidthArray[i] = -1;
                continue;
            }
            int length = i / 2;
            int max = i - 1;
            int count = 0;
            while(length > 0){
                if(P[(length - 1)] == P[max]){
                    count += 1;
                    max -= 1;
                }
                length -= 1;
            }
            maxBoundaryWidthArray[i] = count;
        }
        for(int i = 0; i<maxBoundaryWidthArray.length-1; i++){
            System.out.println(" : "+maxBoundaryWidthArray[i]);
        }
        return maxBoundaryWidthArray;
    }

    public static List kmpSearch(char[] T, char[] P){
        List matchPrefixIndexResult = new LinkedList<Integer>(); //결과값
        int[] maxBoundaryWidthArray = getMaxBoundaryWidthArray(P);
        int currentIndex = 0;
        while((currentIndex + P.length) <= T.length){

            int prefixIndex = 0;
            while(prefixIndex < P.length){
                if(T[currentIndex + prefixIndex] == P[prefixIndex]){
                    prefixIndex += 1;
                }
                else{
                    break;
                }
            }
            if(prefixIndex == P.length){
                matchPrefixIndexResult.add(currentIndex + 1);
            }
            int move = prefixIndex - maxBoundaryWidthArray[prefixIndex];
            currentIndex += move;
        }
        return matchPrefixIndexResult;
    }

}


/**

 솔직히 최대 경계 너비에 대해 이해가 안됐다 그래서 다른 자료들을 찾아보았다
 접두부(prefix)와 접미부(suffix)가 무엇인지 알아야한다
 BAABABAA라는 문자열이 있을 경우

 접두부                접미부
 B                   A
 BA                  AA
 BAA                 BAA -->접두부와 접미부가 같다
 BAAB                ABAA
 BAABA               BABAA
 BAABAB              ABABAA
 BAABABA             AABABAA
 BAABABAA            BAABABAA


 BAA (BA) BAA
 여기서  (BA)를 접두부와 접미부의 경계라고 한다

 자 그럼 KMP알고리즘의 원리(비교할 필요가 없는 부분)에 대해 알아보자
 1. 비교할 패턴을 문자열의 첫번째에 위치시킨다
 2. 먼저 비교할 패턴을 문자열의 비교할 대상의 위치시키고 비료를 한다
 3. 패턴의 왼쪽에서 오른쪽으로 비교하면서 일치하지 않는 부분을 찾는다
 (일치하면 문자열을 찾는데 성공)
 (일치하지 않으면 4번으로 진행)
 4. 일치하지 않는 부분의 왼쪽 부분을 가지고 (패턴안의 패턴) 경계를 찾는다
 (경계를 찾으면 5로 이동)
 (경계를 찾지 못하면 문자열의 패턴의 틀린 부분만큼 이동)

 5. 경계를 찾으면 접미부와 접두부가 나올것이다 경계가 1개면 상관이 없지만 2개이상 나올 수도 있다
 여기서 선택하는 경계는 경계가 최대가 되었을 경우를 설정해주는 것이다
 그리고 최대 경계일 경우의 접두부와 접미부가 있다면 그 접두부의 길이의 접두부시작위치에서 접미부 위치로 이동을 시켜준다
 6. 이동을 하면 2번으로 다시 이동하여 지속적으로 수행

 자
 BAABAABAB라는 문자열이 있다
 여기서 BAABAB를 찾으려고 한다
 BAABA(A)
 BAABA(B)<-여기가 본문과 틀리다

 BAABA에서 BA A BA 로 접두부 경계 접미부를 찾았다

 접두부의 시작인 B(0)에서 접미부의 시작인 B(3)까지 이동시킨다 즉 3만큼 이동
 그래서 다시 처음부터 비교를 시작한다


 **하지만 여기서 생각해 볼 것이 생긴다
 바로 경계를 찾는데 있어 소요되는 비용이다. 매번 경계를 찾다보면 한칸 이동하는 것보다 더 들수도 있다
 그래서 찾으려는 패턴을 가지고 이동경로 테이블을 만들어 주는 것이다
 처음 이 동작을 수행하면 그 표를 복 이동경로만 보고 진행하기 때문에 매번 경계를 찾는 일을 제거할 수 있다

 http://carstart.tistory.com/143 참고 
*/
/**
 * Created by dongdor on 2016. 8. 20..
 */

import java.io.IOException;
import java.util.Scanner;

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

public class KMPsearch {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        String[] T = sc.nextLine().split("");
        
    }


}

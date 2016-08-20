/**
 * Created by dongdor on 2016. 8. 20..
 */

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
        최대 경계 너비  :  일치하는 
 */
public class KMPsearch {


}

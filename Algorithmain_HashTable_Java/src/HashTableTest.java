/**
 * Created by dongdor on 2016. 8. 4..
 */

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 해싱은 키값을 비교함으로써 탐색하고자하는 항목에 접근하는 것을 이야기한다
 *
 * 해시 테이블을 이용한 탐색을 해싱이라고 한다.
 * HashFunction : 탐색키를 입력으로 받아서 해시 주소를 생성한다.
 *
 * ex) 9999(탐색키) -> HashFunction(9999) -> 1024(해시주소)
 *
 * HashTable : 해시 주소에 매핑해서 값을 저장하는 배열
 * 해시테이블은 HashTable[0], HashTable[1], .....Hash[M-1] 총 M개의 버킷으로 구성이 된다.
 *
 * 좋은 해시 함수가 되기 위해선...
 * - 충돌이 적어야한다
 * --> Open-Addressing
 *      충돌이 일어날때 해시함수에 의해 얻어진 주소가 아니더라도 다른 주소를 사용할 수 있도록 허용
 *      1. 선형탐사 : 해시함수로부터 얻은 해시함수 주소에 다른값이 입력되어 있다면 다음 주소에 저장한다
 *      2. 제곱탐사 : 선형탐사는 고정폭을 기준으로 이동했던 것과 다르게 제곱탐사는 이동폭이 제곱으로 늘어나는 차이이다
 *      3. 이중해싱 : 2개의 해시함수를 이용해서 하나의 해시함수로 충돌이 일어났을 때 다른 하나로 이동폭을 얻는다
 *
 *      이렇게 총돌을 해결해도 해시테이블의 용량이 모두 차버린다면 테이블의 크기를 늘려야하고 늘린 해시테이블의 크기에 맞춰서
 *      다시 데이터를 해싱해야한다
 *      --> 재해싱이라고 한다
 *
 * --> Chaining
 *      충돌이 일어날 때 각각의 버킷에서 가리키고 있는 인덱스에 연결리스트로 연결하여 저장한다고 생각한다
 * - 해시 함수 값이 해시테이블의 주소영역 내에서 고르게 분포되어야 한다
 * - 계산이 빨라야 합니다
 *
 * 해시테이블은 메모리상에 존재하기 때문에 I/O속도가 굉장히 빠르다.
 * 간단한 작업이라면 DB에 넣지말고 해시테이블에서 작업을 하는 것도 좋은 방법이다 
 */
public class HashTableTest {

    public static void main(String args[]){

        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

        //해시 테이블에 키와 값 집어 넣기
        ht.put("abc",1);
        ht.put("abc1",2);
        ht.put("abc2",3);

        //해시 테이블에 있는 값 꺼내오기
        Enumeration en = ht.keys();

        while(en.hasMoreElements()){
            String key = en.nextElement().toString();
            System.out.println(key + " : "+ht.get(key));
        }
    }
}










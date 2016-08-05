/**
 * Created by dongdor on 2016. 8. 4..
 */

/**
 * DFS(깊이 우선 탐색, Depth First Search)
 * : 스택을 이용한다
 * 깊이 우선 탐색은 더 깊이 들어갈 수 있을 때까지 들어간다고 생각하면 쉽다
    1) 시작정점을 '방문함'으로 바꿔준다 (따로 방문확인 배열이 존재함)
    2) 방문한 정점과 이웃하고 있는 정점 중에 아직 방문하지 않은 곳을 선택하여
        이를 시작정점으로 다시 1)을 수행한다
    3) 더이상 시작정점이 방문하지 않은 인접정점이 없으면 이전 정점으로 돌아가서 2)를 수행한다
    4) 이전 정점으로 돌아가도 더이상 방문할 곳이 없다면 그래프의 모든 정점을 방문한 것이다
    5) 탐색을 종료한다
 */
import java.util.Scanner;

public class DfsTest {

    static int[][] adjacencyMatrix; //인접행렬
    static boolean[] isVisit; //정점의 방문 확인
    static int vCount; // 정점의 수
    static int eCount; // 간선의 수

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정점의 수, 간선의 수를 입력해 주세요");

        //정점의 수
        vCount = scanner.nextInt();

        //간선의 수
        eCount = scanner.nextInt();

        adjacencyMatrix = new int[vCount][vCount];
        isVisit = new boolean[vCount];

        for(int i = 0; i < eCount; i++){
            System.out.println("간선을 입력해주세요");
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();

            adjacencyMatrix[t1-1][t2-1] = 1;
        }
        dfs(1);
    }

    public static void dfs(int v){
        isVisit[v-1] = true;
        for(int i = 1; i<=vCount; i++){
            //adjacencyMatrix[v-1][i-1] == 1이란 뜻은 연결되어있다는 뜻이다
            //!isVisit[i-1]이란 뜻은 방문하지않았다는 뜻이다
            //따라서 1, 1 일경우 연결되어있지않으므로 탈출!이 처음에 뜨게 된것이다
            if(adjacencyMatrix[v-1][i-1] == 1 && !isVisit[i-1]){
                System.out.println(v+" 에서 "+ i + " 로 이동 ");
                //i를 정점으로해서 다시 간선을 찾는다.
                dfs(i);
            }
            System.out.println("탈출!");
        }
    }
}

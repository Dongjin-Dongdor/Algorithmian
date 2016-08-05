import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Created by dongdor on 2016. 8. 4..
 */
public class BfsTest {

    static int[][] adjacencyMatrix; // 인접행렬
    static boolean[] isVisit; // 정점의 방문 확인
    static int vCount; // 정점의 수
    static int eCount; // 간선의 수
    static Queue queue;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        queue = new LinkedList<Integer>();
        System.out.println("정점의 수, 간선의 수를 입력해 주세요 ");
        vCount = scanner.nextInt();
        eCount = scanner.nextInt();

        adjacencyMatrix = new int[vCount][vCount];
        isVisit = new boolean[vCount];

        for(int i = 0; i< eCount; i++){
            System.out.println("간선을 입력해주세요");
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();

            adjacencyMatrix[t1-1][t2-1] = 1;
        }
        //시작점 표시
        bfs(1);
    }

    public static void bfs(int v){
        isVisit[v-1] = true;
        queue.add(v); //Enqueue

        while(!queue.isEmpty()){
            v = (int) queue.poll(); //Dequeue
            for(int i = 1; i <= vCount; i++){
                if(adjacencyMatrix[v-1][i-1] == 1 && !isVisit[i-1]){
                    System.out.println(v+ " 에서 "+ i + " 로 이동");
                    isVisit[i-1] = true;
                    queue.add(i); //Enqueue
                }
            }

        }
    }
}

import java.util.Stack;

/**
 * Created by dongdor on 2016. 8. 8..
 */
public class DijkstraTest {

    static int inf = 99999; // 무한대 값
    public static void main(String[] args){

        int[][] weightMatrix = {
                {   0,   7, inf, inf,   3,  10, inf},
                {   7,   0,   4,  10,   2, inf, inf},
                { inf,   4,   0,   2, inf,   6, inf},
                { inf,  10,   2,   0,  11,   9,   4},
                {   3,   2, inf,  11,   0, inf,   5},
                {  10, inf,   6,   9, inf,   0, inf},
                { inf, inf, inf,   4,   5, inf,   0}
        };

        dijkstra(weightMatrix, 0, 3); // 0 부터 3까지 최단거리
    }


    public static void dijkstra(int[][] graph, int start, int end){

        int vCount = graph[0].length; //정점의 수
        boolean[] isVisit = new boolean[vCount]; //방문 배열
        int[] distance = new int[vCount]; // 거리 배열
        int[] historyPath = new int[vCount]; //히스토리 배열

        int nextVertex = start; // distance 배열의 최소값의 정점
        int min = 0; //distance 배열의 최소값

        //초기화 작업
        for(int i = 0; i < vCount; i++){
            isVisit[i] = false; //방문한 곳 없다고 초기화
            distance[i] = inf; //전부 다 무한대로 초기화
            historyPath[i] = inf; //전부다 무한대로 초기화
        }
        distance[start] = 0; //시작점을 0으로 초기화

        //다익스트라 실행
        while(true){
            min = inf;//최소값을 infinity 초기화

            for(int j = 0; j <vCount; j++){

                System.out.println("J : "+j);
                //distance[j] 덕분에 시작점부터 시작할 수 있다.
                //가장 먼저 방문했던 노드는 제외한다
                //또한 최소값을 찾기위한 조사(선택정렬을 생각하면 된다)
                if(isVisit[j] == false && distance[j] < min){

                    nextVertex = j;// 다음으로 이동할 정점 선택
                    min = distance[j]; // 다음으로 이동한 최소값

                }
            }
            System.out.println("*******************");
            if(min == inf)
                break; // 최소값이 infinity이면 모든 정점을 지났다는 것, 최소값이 모든 정점을 지났으면
                       // infinity
            isVisit[nextVertex] = true; // 다음으로 이동할 정점 방문
            for(int j = 0; j < vCount; j++){
                int distanceVertex = distance[nextVertex] + graph[nextVertex][j]; // 정점에서 다른 정점사이의 거리

                if(distance[j] > distanceVertex){ //정점에서 다른 정점에서의 거리가 distance 배열보다 적다면 교체해 준다
                    distance[j] = distanceVertex; // 교체해 준다
                    historyPath[j] = nextVertex; // 교체된다면 그 지점의 정점의 기록을 남긴다
                }
            }
        }

        System.out.print(start + " 부터 " + " 도착점 : "+ end);
        System.out.println(" 최단거리 : "+distance[end]); //최종에는 start 정점부터 모든 최단 경로가 생선된다

        printPath(historyPath, start, end);
    }

    public static void printPath(int[] historyPath, int start, int end){
        Stack<Integer> path = new Stack<Integer>();
        int vertex = end; //거꾸로 탐색한다
        while(true){
            path.push(vertex);
            if(vertex == start)
                break;
            vertex = historyPath[vertex]; //탐색
        }

        System.out.print(start + " 부터 " + end + " 까지 경로는 : ");
        while(!path.isEmpty()){
            System.out.print(" "+ path.pop());
        }

    }
}
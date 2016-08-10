/**
 * Created by dongdor on 2016. 8. 10..
 */
/**
 * 문제
 *
 * N개의 숫자로 구분된 각각의 마을에 한명의 학생이 살고 있다
 * 어느날 이 N명의 학생이 X번 마을에 모여서 파티를 벌이기로 했다 이 마을 사이에는 총 M개의 단방향 도로들이 있고
 * i번째 길을 지나는데 T의 시간을 시보힌다
 * 각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다
 * 이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. N명의 학생들 중 오고가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
 *
 *
 * 입력
 *
 * 첫째 줄에 N//, M, X가 공백으로 구분되어 입력된다.
 * 두번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점 끝점 그리고 이 도로를 지나는데 필요한 소요시간이 들어간다
 */

import java.util.Scanner;

public class PartyTest {

    static int inf = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount, roadCount, partyPlace;
        int[][] weightMatrix;
        int maxFloyd = 0;
        int maxDijkstra = 0;

        //입력 시작
        studentCount = sc.nextInt();
        weightMatrix = new int[studentCount][studentCount];
        roadCount = sc.nextInt();
        partyPlace = sc.nextInt() - 1;
        sc.nextLine();


        //무한대로 초기화
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < studentCount; j++) {
                weightMatrix[i][j] = inf;
            }
        }

        for (int i = 0; i < roadCount; i++) {
            String[] inputs = sc.nextLine().split(" ");
            //vertex 입력
            weightMatrix[Integer.parseInt(inputs[0]) - 1][Integer.parseInt(inputs[1]) - 1] = Integer.parseInt(inputs[2]);
        }
        sc.close();
        //입력 종료


        //플로이드 알고리즘

        System.out.println("Floyd 알고리즘");

        int[][] resultFloyd = floyd(weightMatrix);
        printGraph(resultFloyd, studentCount);

        for (int i = 0; i < studentCount; i++) {
            if (i == partyPlace) continue;
            int tempTime = resultFloyd[i][partyPlace] + resultFloyd[partyPlace][i];
            if (tempTime > maxFloyd) maxFloyd = tempTime;
        }
        System.out.println(maxFloyd + "");


        //다익스트라
        System.out.println("Dijkstra 알고리즘");
        int[][] resultDijkstra = new int[studentCount][studentCount];
        for (int i = 0; i < studentCount; i++) {
            resultDijkstra[i] = dijkstra(weightMatrix, i);// 모든 정점에 대한 알고리즘 계산
        }
        printGraph(resultDijkstra, studentCount);
        for (int i = 0; i < studentCount; i++) {
            if (i == partyPlace) continue;
            int tempTime = resultDijkstra[i][partyPlace] + resultDijkstra[partyPlace][i];
            if (tempTime > maxDijkstra) maxDijkstra = tempTime;
        }
        System.out.println(maxDijkstra + "");
    }

    //플로이드 알고리즘 구현
    public static int[][] floyd(int[][] graph) {
        int count;
        int i, j, k;
        count = graph.length;
        int resultGraph[][] = new int[count][count];
        for (i = 0; i < count; i++)
            for (j = 0; j < count; j++)
                resultGraph[i][j] = graph[i][j];

        for (k = 0; k < count; k++) {
            for (i = 0; i < count; i++) {
                for (j = 0; j < count; j++) {

                }
            }
        }
        return resultGraph;
    }

    //다익스트라 알고리즘 구현

    public static int[] dijkstra(int[][] graph, int start){
        int vCount = graph[0].length; // 정점의 수
        boolean[] isVisit = new boolean[]; // 방문 배열
        int[] distance = new int[vCount]; // 거리배열

        int nextVertex = start; // distance 배열의 최소값의 정점
        int min = 0;

        for(int i = 0; i < vCount; i++){
            isVisit[i] = false; // 방문한 곳 없다고 초기화
            distance[i] = inf; // 전부다 무한대로 초기화

        }

        distance[start] = 0; // 시작점 0으로 초기화

        //다익스트라 실행
        while(true){
            min = inf;//최소값을 infinity 초기화
            for(int j = 0; j < vCount; j++){
                if(isVisit[j] == false && distance[j]<min){
                    nextVertex = j;
                    min = distance[j];
                }
            }
            if(min == inf)
                break; //최소값이 infinity이면 모든 정점을 지났다는 것 최소값이 모든 정점을 지났으면  infinity
            isVisit[nextVertex] = true;

            for(int j = 0; j < vCount; j++){
                int distanceVertex = distance[nextVertex] + graph[nextVertex][j]; //정점에서 방문한 다른 정점의 거리
                if(distance[j] > distanceVertex){ // 정점에서 다른 정점에서의 거리가 distance 배열보다 적다면 교체해준다

                    distance[j] = distanceVertex; //교체해준다
                }
            }
        }
        return distance;
    }

    public static void printGraph(int[][] graph, int count){
        for(int i = 0; i < count; i++){
            System.out.print(i + " : ");
            for(int j = 0; j < count; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

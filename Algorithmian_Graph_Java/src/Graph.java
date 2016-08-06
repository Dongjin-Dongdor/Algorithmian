/**
 * Created by dongdor on 2016. 8. 4..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph{

    static int gRow;
    static int gColumn;
    static int[][] gMatrix;

    public static void main(String[] args) throws IOException{

        LinkedList<Point> queue;
        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("N과 M을 입력해주세요 : ");
        String[] rowCol = bfReader.readLine().split(" ");
        gRow = Integer.parseInt(rowCol[0]);
        gColumn = Integer.parseInt(rowCol[1]);

        gMatrix = new int[gRow][gColumn];
        queue = new LinkedList<Point>();
        for(int i = 0; i< gRow; i++){
            String[] column = bfReader.readLine().split("");
            for(int j = 0; j<gColumn; j++){
                int input = Integer.parseInt(column[j]);
                gMatrix[i][j] = input;

            }
        }
        bfReader.close();

        graph_Algorithm(gMatrix, queue, 0, 0, gRow, gColumn);
    }

    //graph_Algorithm(gMatrix, queue, 0, 0, gRow(4), gColumn(6));
    public static void graph_Algorithm(int[][] graphMatrix, LinkedList<Point> queue, int rStart, int cStart, int rEnd, int cEnd){
        //초기값 :  rStart = 0, cStart = 0, rEnd = 4, cEnd = 6

        //minLength = 24 현재의 minLength는 최대값이다

        int minLength = rEnd * cEnd;
        System.out.println(minLength);
        queue.add(new Point(rStart, cStart, 1)); // Enqueue

        while( !queue.isEmpty()){
            Point vertex = (Point) queue.poll(); // Dequeue
            System.out.print("큐에서 방금 빼낸 따끈한 놈 row : "+vertex.row+" 과 ");
            System.out.print("column : "+vertex.column+" 과 ");
            System.out.println("length : "+vertex.length+" ; ");

            //vertex.row 가 rEnd vertex.column 이 cEnd. 즉 끝일 경우
            if((vertex.row == rEnd - 1 && vertex.column == cEnd - 1)){
                System.out.println("if loop 1 ");
                if(minLength > vertex.length){
                    minLength = vertex.length;
                }
                break;
            }

            graphMatrix[vertex.row][vertex.column] = 0;

            // 행렬을 벗어나지 않고, 위로 갈 수 있다면 위의 지점의 좌표정보와 길이를 큐에 넣는다.
            if ((vertex.row > 0) && (gMatrix[vertex.row - 1][vertex.column] == 1)) {
                System.out.println("loop 2 ");
                queue.add(new Point(vertex.row - 1, vertex.column, vertex.length + 1));
                Print_Queue(queue);
            }

            // 행렬을 벗어나지 않고, 밑으로 갈 수 있다면 밑의 지점의 좌표정보와 길이를 큐에 넣는다.
            if ((vertex.row < (rEnd - 1)) && (gMatrix[vertex.row + 1][vertex.column] == 1)) {
                System.out.println("loop 3 ");
                queue.add(new Point(vertex.row + 1, vertex.column, vertex.length + 1));
                Print_Queue(queue);
            }

            // 행렬을 벗어나지 않고, 왼쪽으로 갈 수 있다면 왼쪽의 지점의 좌표정보와 길이를 큐에 넣는다.
            if ((vertex.column > 0) && (gMatrix[vertex.row][vertex.column - 1] == 1)) {
                System.out.println("loop 4 ");
                queue.add(new Point(vertex.row, vertex.column - 1, vertex.length + 1));
                Print_Queue(queue);
            }

            // 행렬을 벗어나지 않고, 오른쪽으로 갈 수 있다면 오른쪽의 지점의 좌표정보와 길이를 큐에 넣는다.
            if ((vertex.column < (cEnd - 1)) && (gMatrix[vertex.row][vertex.column + 1] == 1)) {
                System.out.println("loop 5 ");
                queue.add(new Point(vertex.row, vertex.column + 1, vertex.length + 1));
                Print_Queue(queue);
            }
            System.out.println("");
        }

        System.out.println(" "+minLength);

    }

    public static void Print_Queue(LinkedList<Point> queue){

        System.out.println("큐 출력 ");
        for(Point point : queue){
            System.out.print(point.row+"과 ");
            System.out.print(point.column+" ; ");
        }
    }

    private static class Point{
        int row;
        int column;
        int length;

        public Point(int row, int column, int length){
            this.row = row;
            this.column = column;
            this.length = length;
        }
    }


}

/**
 * 그래프는 G = (V,E)로 표현되며 G(Graph)는 V(Vertext,정점) E(Edge, 간선)으로 이루어진 결합이다
 *
 * 이러한 그래프를 인접행렬과 인접리스트를 통해서 표현이 된다
 * 인행렬이란 정점의 인접관계를 행렬로 표현한 것이다
 */

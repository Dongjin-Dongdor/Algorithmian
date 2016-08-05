/**
 * Created by dongdor on 2016. 8. 4..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Graph{

    static int gRow;
    static int gColumn;
    static int[][] gMatrix;

    public static void main(String[] args) throws IOException{

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("N과 M을 입력해주세요 : ");
        String[] rowCol = bfReader.readLine().split(" ");
        gRow = Integer.parseInt(rowCol[0]);
        gColumn = Integer.parseInt(rowCol[1]);

        gMatrix = new int[gRow][gColumn];
        for(int i = 0; i< gRow; i++){
            String[] column = bfReader.readLine().split("");
            for(int j = 0; j<gColumn; j++){
                int input = Integer.parseInt(column[j]);
                gMatrix[i][j] = input;

            }
        }
        bfReader.close();
        
        graph_Algorithm(gRow,gColumn,gMatrix);
    }


    public static void graph_Algorithm(int row, int Column, int[][] array){


    }
}

/**
 * 그래프는 G = (V,E)로 표현되며 G(Graph)는 V(Vertext,정점) E(Edge, 간선)으로 이루어진 결합이다
 *
 * 이러한 그래프를 인접행렬과 인접리스트를 통해서 표현이 된다
 * 인행렬이란 정점의 인접관계를 행렬로 표현한 것이다
 */

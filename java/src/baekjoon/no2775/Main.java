package baekjoon.no2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];

        for(int i = 1; i < 15; i++) {
            apt[0][i] = i;
        }

        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                for(int k = 1; k <= j; k++) {
                    apt[i][j] = apt[i-1][j] + apt[i][j-1];
                }
            }
        }


        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apt[k][n]);
        }
    }
}

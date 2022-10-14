package baekjoon.no1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] matrix1;
    static int[][] matrix2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        matrix1 = new int[N][M];
        matrix2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                matrix1[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                matrix2[i][j] = tmp.charAt(j) - '0';
            }
        }

        if(N < 3 || M < 3) {
            System.out.println(isSame() ? cnt : -1);
            return;
        }

        for(int i = 0; i < N-2; i++) {
            for(int j = 0; j < M-2; j++) {
                if(matrix1[i][j] != matrix2[i][j]) {
                    change(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(isSame() ? cnt : -1);
    }

    private static void change(int r, int c) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                matrix1[i][j] = matrix1[i][j] == 0 ? 1 : 0;
            }
        }
    }

    private static boolean isSame() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

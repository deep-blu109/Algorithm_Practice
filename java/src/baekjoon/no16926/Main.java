package baekjoon.no16926;
// 틀림


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int size1 = Math.min(N, M) / 2;
        int size2 = (N*M) - (N-2) * (M-2);

        int[][] arr = new int[N][M];
        int[][] groups = new int[size1][size2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < size1; i++) {
            int[] group = groups[i];

            int idx = 0;
            int nowR = N - i - 1;
            int nowC = M - i - 1;
            for(int j = i; j < nowC; j++) {
                group[idx++] = arr[i][j];
            }
            for(int j = i; j < nowR; j++) {
                group[idx++] = arr[j][nowC];
            }
            for(int j = nowC; j > 0; j--) {
                group[idx++] = arr[nowR][j];
            }
            for(int j = nowR; j > 0; j--) {
                group[idx++] = arr[j][i];
            }
        }

        for(int i = 0; i < size1; i++) {
            int[] group = groups[i];

            int idx = 0;
            int nowR = N - i - 1;
            int nowC = M - i - 1;
            for(int j = i; j < nowC; j++) {
                group[idx++] = arr[i][j];
            }
            for(int j = i; j < nowR; j++) {
                group[idx++] = arr[j][nowC];
            }
            for(int j = nowC; j > 0; j--) {
                group[idx++] = arr[nowR][j];
            }
            for(int j = nowR; j > 0; j--) {
                group[idx++] = arr[j][i];
            }
        }
    }
}

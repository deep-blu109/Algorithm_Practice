package baekjoon.no2758;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N, M;

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[N+1][M+1];

            for(int j = 0; j <= M; j++){
                dp[0][j] = 1;
            }

            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= M; k++){
                    dp[j][k] = dp[j-1][k/2] + dp[j][k-1];
                }
            }

            bw.write(String.valueOf(dp[N][M]) + "\n");
        }

    }
}

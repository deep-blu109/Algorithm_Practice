package baekjoon.no16507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][] photo = new int[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= C; j++) {
                photo[i][j] = photo[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int result = 0;
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for(int j = r1; j <= r2; j++) {
                result += photo[j][c2] - photo[j][c1-1];
            }

            result /= (r2 - r1 + 1) * (c2 - c1 + 1);

            System.out.println(result);
        }
    }
}

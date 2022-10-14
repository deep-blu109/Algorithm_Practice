package baekjoon.no14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ans;

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        ans = 2 * N;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-1; j++) {
                if(map[i][j] == map[i][j+1]) {
                    continue;
                }
                else if(map[i][j] - map[i][j+1] == 1) {
                    for(int k = 2; k <= L; k++) {
                        if(map[i][j+k] == map[i][j+1]) {

                        }
                    }
                }

            }
        }




        System.out.println(ans);
    }
}

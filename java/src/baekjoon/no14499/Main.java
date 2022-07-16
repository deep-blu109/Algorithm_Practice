package baekjoon.no14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int n, s, e, w, up, down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++){
            int tmp = down;
            switch (st.nextToken()){
                case "1":
                    if(outOfRange(x, y+1)){
                        continue;
                    }
                    y++;
                    down = e;
                    e = up;
                    up = w;
                    w = tmp;
                    break;
                case "2":
                    if(outOfRange(x, y-1)){
                        continue;
                    }
                    y--;
                    down = w;
                    w = up;
                    up = e;
                    e = tmp;
                    break;
                case "3":
                    if(outOfRange(x-1, y)){
                        continue;
                    }
                    x--;
                    down = n;
                    n = up;
                    up = s;
                    s = tmp;
                    break;
                case "4":
                    if(outOfRange(x+1, y)){
                        continue;
                    }
                    x++;
                    down = s;
                    s = up;
                    up = n;
                    n = tmp;
                    break;
            }

            System.out.println(up);
            change_num();
        }
    }
    private static void change_num() {
        if(map[x][y] == 0){
            map[x][y] = down;
        }
        else{
            down = map[x][y];
            map[x][y] = 0;
        }
    }
    private static boolean outOfRange(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M){
            return true;
        }
        return false;
    }
}

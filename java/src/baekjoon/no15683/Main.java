package baekjoon.no15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] office;
    static int max;
    static int ans = 64;
    static Cctv[] cctvs = new Cctv[64];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        max = N * M;
        int idx = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] != 0) {
                    max--;
                    if (office[i][j] != 6) {
                        cctvs[idx++] = new Cctv(i, j);
                    }
                }
            }
        }

        solve(0, 0, office.clone());

        System.out.println(ans);
    }

    static class Cctv {
        int r;
        int c;

        Cctv(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void solve(int idx, int cnt, int[][] officeNow) {
        if(cctvs[idx] == null) {
            ans = Math.min(ans, max - cnt);
            return;
        }

        int[][] officeTmp = officeNow.clone();
        int r = cctvs[idx].r;
        int c = cctvs[idx].c;

        int tmp = cnt;
        switch (office[r][c]) {
            case 1:
                for(int i = 0; i < 4; i++) {
                    solve(idx+1, cnt + check(r, c, i, officeTmp), officeTmp);
                    officeTmp = officeNow.clone();
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++) {
                    solve(idx+1, cnt + check(r, c, i, officeTmp) + check(r, c, i+2, officeTmp), officeTmp);
                    officeTmp = officeNow.clone();
                }
                break;
            case 3:
                for(int i = 0; i < 3; i++) {
                    solve(idx+1, cnt + check(r, c, i, officeTmp) + check(r, c, i+1, officeTmp), officeTmp);
                    officeTmp = officeNow.clone();
                }
                solve(idx+1, cnt + check(r, c, 3, officeTmp) + check(r, c, 0, officeTmp), officeTmp);
                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    solve(idx+1, cnt + check(r, c, i, officeTmp) + check(r, c, (i+1)%4, officeTmp) + check(r, c, (i+2)%4, officeTmp), officeTmp);
                    officeTmp = officeNow.clone();
                }
                break;
            case 5:
                solve(idx+1, cnt + check(r, c, 0, officeTmp) + check(r, c, 1, officeTmp) + check(r, c, 2, officeTmp) + check(r, c, 3, officeTmp), officeTmp);;
                break;
        }
    }

    private static int check(int r, int c, int dir, int[][] officeTmp) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int cnt = 0;
        r += dr[dir];
        c += dc[dir];
        while (!outOfRange(r, c)) {
            if(officeTmp[r][c] == 6) {
                break;
            }
            else if(officeTmp[r][c] == 0) {
                officeTmp[r][c] = -1;
                cnt++;
            }

            r += dr[dir];
            c += dc[dir];
        }

        return cnt;
    }

    private static boolean outOfRange(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M) {
            return true;
        }
        return false;
    }
}

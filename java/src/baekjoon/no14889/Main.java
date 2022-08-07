package baekjoon.no14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] player;
    static int size;
    static int min = 2000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        player = new int[N][N];
        size = N / 2;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, size, new boolean[N]);

        System.out.println(min);

    }

    private static void comb(int idx, int cnt, boolean[] team) {
        if(cnt == 0) {
            cal_power(team);
            return;
        }

        for(int i = idx; i < N - cnt + 1; i++) {
            team[i] = true;
            comb(i+1, cnt - 1, team);
            team[i] = false;
        }
    }

    private static void cal_power(boolean[] team) {
        int[] teamA = new int[size + 1];
        int[] teamB = new int[size + 1];

        int idxA = 0;
        int idxB = 0;
        for(int i = 0; i < N; i++) {
            if(team[i]) {
                teamA[idxA++] = i;
            }
            else {
                teamB[idxB++] = i;
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = i+1; j < size; j++) {
                teamA[size] += player[teamA[i]][teamA[j]] + player[teamA[j]][teamA[i]];
                teamB[size] += player[teamB[i]][teamB[j]] + player[teamB[j]][teamB[i]];
            }
        }

        min = Math.min(min, Math.max(teamA[size], teamB[size]) - Math.min(teamA[size], teamB[size]));
    }
}

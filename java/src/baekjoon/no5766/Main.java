package baekjoon.no5766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int N, M;
    static int[][] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (N != 0 && M != 0) {
            rank = new int[N][M];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < M; j++) {
                    rank[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            findRank();

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
    }

    private static void findRank() {
        TreeMap<Integer, Integer> check = new TreeMap<>();
        int first = 1;
        int second = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int now = rank[i][j];

                if(check.containsKey(now)) {
                    int now_value = check.get(now) + 1;
                    check.put(now, now_value);

                    if(first < now_value) {
                        first = now_value;
                    }
                    else if(second < check.get(now)) {
                        second = now_value;
                    }
                }
                else {
                    check.put(now, 1);
                }
            }
        }

        for(int key : check.keySet()) {
            int now = check.get(key);
            if(now == second) {
                System.out.print(key + " ");
            }
        }

        System.out.println();
    }
}

package baekjoon.no2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] member;
    static int min;
    static LinkedList<Integer> candidate = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        member = new boolean[N+1][N+1];
        min = N;

        while (true){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(r == -1) {
                break;
            }

            member[r][c] = true;
            member[c][r] = true;
        }

        for(int i = 1; i <= N ; i++) {
            solve(i);
        }

        System.out.println(min + " " + candidate.size());

        for(Integer i : candidate) {
            System.out.print(i + " ");
        }
    }

    private static void solve(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int cnt = -1;

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;

            for(int i = 0; i < size; i++) {
                int now = q.poll();

                for(int j = 1; j <= N; j++) {
                    if(member[now][j] && !visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        if(cnt < min) {
            candidate = new LinkedList<>();
            candidate.add(start);
            min  = cnt;
        }
        else if(cnt == min) {
            candidate.add(start);
        }
    }
}

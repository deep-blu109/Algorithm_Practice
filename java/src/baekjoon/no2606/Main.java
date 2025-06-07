package baekjoon.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] graph;

    private static int DFS(int com, boolean[] visited, int cnt) {
        if (visited[com]) {
            return 0;
        }

        visited[com] = true;

        for (int i : graph[com]) {
            cnt += DFS(i, visited, 1);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        graph = new LinkedList[com + 1];
        boolean[] visited = new boolean[com + 1];

        for (int i = 1; i <= com; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());

            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            graph[com1].add(com2);
            graph[com2].add(com1);
        }

        System.out.println(DFS(1, visited, 0));
    }
}

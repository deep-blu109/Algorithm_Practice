package baekjoon.no17073;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double cnt = 0;
        boolean[] visited = new boolean[N+1];
        ArrayList<Node> tree = new ArrayList<>();

        tree.add(new Node());
        for(int i = 1; i < N+1; i++){
            tree.add(new Node());
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree.get(n1).addChild(n2);
            tree.get(n2).addChild(n1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            boolean flag = false;

            for(int i : tree.get(now).child){
                if(visited[i]){
                    continue;
                }

                visited[i] = true;
                flag = true;
                q.add(i);
            }

            if(!flag){
                cnt++;
            }
        }

        System.out.println(W / cnt);
    }

    private static class Node {
        ArrayList<Integer> child;

        public Node() {
            child = new ArrayList<>();
        }

        public void addChild(int c){
            child.add(c);
        }
    }
}

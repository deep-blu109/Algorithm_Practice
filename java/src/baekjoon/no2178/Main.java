package baekjoon.no2178;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] maze = new String[N];

        for(int i = 0; i < N; i++){
            maze[i] = sc.next();
        }

        System.out.println(bfs(N, M, maze));
    }

    public static class Pair {
        public int r;
        public int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static int bfs(int N, int M, String[] maze){
        Queue<Pair> bfs_q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int result = 1;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};


        Pair tmp = new Pair(0, 0);
        bfs_q.add(tmp);
        visited[0][0] = true;


        Loop : while(!bfs_q.isEmpty()) {
            result++;
            int size = bfs_q.size();

            for(int i = 0; i < size; i++){
                Pair now = bfs_q.poll();

                for(int j = 0; j < 4; j++){
                    int r = now.r + dr[j];
                    int c = now.c + dc[j];

                    if(!outOfRange(N, M, r, c) && !visited[r][c] && maze[r].charAt(c) == '1'){
                        if(r == N-1 && c == M-1){
                            break Loop;
                        }
                        visited[r][c] = true;
                        Pair pair = new Pair(r, c);
                        bfs_q.add(pair);
                    }
                }
            }
        }

        return result;
    }

    public static boolean outOfRange(int N, int M, int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M){
            return  true;
        }
        return false;
    }
}

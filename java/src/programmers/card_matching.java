package programmers;

import java.util.*;

public class card_matching {
    public static void main(String[] args) {
        int[][] board = {{3,0,0,2}, {0,0,1,0}, {0, 1, 0, 0}, {2, 0, 0, 3}};
        int r = 0;
        int c = 1;

        System.out.println(solution(board, r, c));

    }

    public static int solution(int[][] board, int r, int c) {
        int answer = 0;

        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] != 0) cnt++;
            }
        }

        answer += cnt;
        cnt /= 2;

        int card = board[r][c];
        Node now;

        if(card == 0){
            now = findCard(r, c, board, card);
            answer += now.getCnt();
            card = now.getCard();
        }

        while(cnt > 0) {
            now = findCard(r, c, board, card);

            if(now.getCard() == 0){
                cnt--;
            }

            answer += now.getCnt();
            card = now.getCard();
        }

        return answer;
    }

    static class Node {
        int r;
        int c;
        int cnt;
        int card = 0;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public Node(int r, int c, int cnt, int card) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.card = card;
        }

        public int getR() {
            return this.r;
        }

        public int getC() {
            return this.c;
        }

        public int getCnt() {
            return this.cnt;
        }

        public int getCard() {
            return this.card;
        }
    }

    private static Node findCard(int row, int column, int[][] board, int card) {
        Node result  = new Node(row, column, 0);
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        boolean flag = card == 0 ? false : true;

        visited[row][column] = true;
        q.add(result);

        Loop: while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0; i < 4; i++){
                int nr = node.getR() + dr[i];
                int nc = node.getC() + dc[i];
                int nCnt = node.getCnt() + 1;

                if(outOfRange(nr, nc)){
                    continue;
                }

                if(!visited[nr][nc]){
                    if(flag && board[nr][nc] == card){
                        result = new Node(nr, nc, nCnt);
                        board[nr][nc] = 0;
                        break Loop;
                    }
                    else if(!flag && board[nr][nc] != 0){
                        result = new Node(nr, nc, nCnt, board[nr][nc]);
                        board[nr][nc] = 0;
                        break Loop;
                    }

                    q.add(new Node(nr, nc, nCnt));
                    visited[nr][nc] = true;
                }

                while(true){
                    if(board[nr][nc] != 0){
                        break;
                    }
                    else if(dr[i] != 0){
                        if(nr == 0 || nr == 3)  break;
                    }
                    else if(dc[i] != 0){
                        if(nc == 0 || nc == 3)  break;
                    }

                    nr += dr[i];
                    nc += dc[i];
                }

                if(!visited[nr][nc]){
                    if(flag && board[nr][nc] == card){
                        result = new Node(nr, nc, nCnt);
                        board[nr][nc] = 0;
                        break Loop;
                    }
                    else if(!flag && board[nr][nc] != 0){
                        result = new Node(nr, nc, nCnt, board[nr][nc]);
                        board[nr][nc] = 0;
                        break Loop;
                    }

                    q.add(new Node(nr, nc, nCnt));
                    visited[nr][nc] = true;
                }
            }
        }

        return result;
    }

    private static boolean outOfRange(int r, int c) {
        if(r < 0 || c < 0 || r >= 4 || c >= 4) return true;

        return false;
    }
}

package baekjoon.no3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static class Snake {
        private int row;
        private int col;

        public Snake(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getCol() {
            return col;
        }


        public int getRow() {
            return row;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int l;
        int[][] board = new int[n + 1][n + 1];
        int[] snakeTime;
        char[] snakeDirection;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        board[1][1] = 2;

        l = Integer.parseInt(br.readLine());
        snakeTime = new int[l];
        snakeDirection = new char[l];


        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            snakeTime[i] = Integer.parseInt(st.nextToken());
            snakeDirection[i] = st.nextToken().charAt(0);
        }


        Deque<Snake> snake = new ArrayDeque<>();
        snake.add(new Snake(1, 1));

        int direction = 1;
        int time = 0;
        int idx = 0;

        while (true) {
            time++;

            Snake now = snake.getFirst();
            int row = now.getRow();
            int col = now.getCol();

            if (direction == 0) {
                row--;
            } else if (direction == 1) {
                col++;
            } else if (direction == 2) {
                row++;
            } else {
                col--;
            }

            if (row == 0 || col == 0 || row == n + 1 || col == n + 1 || board[row][col] == 2) {
                break;
            }

            snake.addFirst(new Snake(row, col));

            if (board[row][col] == 0) {
                Snake cut = snake.pollLast();
                board[cut.getRow()][cut.getCol()] = 0;
            }

            board[row][col] = 2;

            if (idx < l && time == snakeTime[idx]) {
                if (snakeDirection[idx] == 'L') {
                    direction--;
                    if (direction == -1) {
                        direction = 3;
                    }
                } else {
                    direction = (direction + 1) % 4;
                }

                idx++;
            }
        }

        System.out.print(time);
    }
}

package baekjoon.no15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] dragon = new boolean[1000][1000];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            curveDragon(x, y, d, g);
        }

        System.out.println(checkDragon());
    }

    private static void curveDragon(int x, int y, int d, int g) {
        int size = 1;

        dragon[x][y] = true;
        x += dx[d];
        y += dy[d];
        dragon[x][y] = true;

        for (int j = 0; j < g; j++) {
            for (int k = 0; k < size; k++) {
                d = (d + 1) % 4;
                x += dx[d];
                y += dy[d];

                dragon[x][y] = true;
            }
            size *= 2;
        }
    }

    private static int checkDragon() {
        int result = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (dragon[i][j] && dragon[i + 1][j] && dragon[i][j + 1] && dragon[i + 1][j + 1]) result++;
            }
        }

        return result;
    }
}

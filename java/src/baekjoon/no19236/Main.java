package baekjoon.no19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static class Fish {
        int num;
        int dir;

        Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }

        Fish(Fish fish) {
            this.num = fish.num;
            this.dir = fish.dir;
        }
    }

    private static class Location {
        int r;
        int c;

        Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Fish[][] fishes = new Fish[4][4];
    static Location[] loc = new Location[17];
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(num, Integer.parseInt(st.nextToken()) - 1);
                fishes[i][j] = fish;
                loc[num] = new Location(i, j);
            }
        }

        answer = fishes[0][0].num;
        loc[fishes[0][0].num] = null;
        fishes[0][0].num = 0;

        moveShark(0, 0, answer);

        System.out.println(answer);
    }

    private static void moveShark(int r, int c, int sum) {
        answer = Math.max(answer, sum);

        moveFishes();

        Fish[][] tmpFishes = new Fish[4][4];
        Location[] tmpLoc = loc.clone();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fish fish = new Fish(fishes[i][j]);
                tmpFishes[i][j] = fish;
            }
        }

        int dir = fishes[r][c].dir;
        int nr = r;
        int nc = c;
        while (true) {
            nr += dr[dir];
            nc += dc[dir];

            if (outOfRange(nr, nc)) {
                break;
            }

            int num = fishes[nr][nc].num;
            if (num == -1) {
                continue;
            }

            loc[num] = null;
            fishes[nr][nc].num = 0;
            fishes[r][c].num = -1;

            moveShark(nr, nc, sum + num);

            loc = tmpLoc.clone();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Fish fish = new Fish(tmpFishes[i][j]);
                    fishes[i][j] = fish;
                }
            }
        }
    }

    private static void moveFishes() {
        for (int i = 1; i <= 16; i++) {
            if (loc[i] == null) {
                continue;
            }

            int r = loc[i].r;
            int c = loc[i].c;
            Fish nowFish = fishes[r][c];
            int dir = nowFish.dir;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!outOfRange(nr, nc)) {
                Fish changeFish = fishes[nr][nc];
                int changeNum = changeFish.num;

                if (changeNum == 0) {
                    fishes[r][c].dir = (fishes[r][c].dir + 1) % 8;
                    i--;
                } else if (changeNum == -1) {
                    fishes[nr][nc] = nowFish;
                    fishes[r][c] = changeFish;
                    loc[i].r = nr;
                    loc[i].c = nc;
                } else {
                    fishes[nr][nc] = nowFish;
                    fishes[r][c] = changeFish;
                    loc[i].r = nr;
                    loc[i].c = nc;
                    loc[changeNum].r = r;
                    loc[changeNum].c = c;
                }
            } else {
                fishes[r][c].dir = (fishes[r][c].dir + 1) % 8;
                i--;
            }
        }
    }


    private static boolean outOfRange(int r, int c) {
        if (r < 0 || c < 0 || r >= 4 || c >= 4) {
            return true;
        }
        return false;
    }
}

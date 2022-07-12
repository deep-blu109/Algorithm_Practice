package baekjoon.no2531;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, d, k, c, ans = 0;
        int[] belt = new int[30001];
        boolean[] check = new boolean[3001];

        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        for(int i = 0; i < N; i++){
            belt[i] = sc.nextInt();
        }

        check[c] = true;

        for(int i = 0; i < N; i++){
            int cnt = 1;
            boolean[] now = Arrays.copyOf(check, check.length);
            for(int j = 0; j < k; j++){
                int idx = i+j;
                idx = idx >= N ? idx % N : idx;

                if(!now[belt[idx]]) {
                    now[belt[idx]] = true;
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}

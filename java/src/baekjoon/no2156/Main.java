package baekjoon.no2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] wine = new int[N+1];
        int[] dp = new int[N+1];

        for(int i = 0; i < N; i++){
            wine[i] = sc.nextInt();
        }
        wine[N] = 0;

        if(N == 1) {
            System.out.println(wine[0]);
            return;
        }

        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(wine[0] + wine[2], wine[1] + wine[2]);
        dp[3] = Math.max(wine[0] + wine[1] + wine[3], wine[0] + wine[2] + wine[3]);

        for(int i = 3; i <= N; i++){
           int num1 = 0, num2 = 0, num3 = 0;

           num1 = dp[i-3] + wine[i];
           num2 = dp[i-2] + wine[i];
           num3 = dp[i-1] + wine[i];
        }

        System.out.println(dp[N-1]);
    }
}
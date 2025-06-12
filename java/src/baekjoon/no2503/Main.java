package baekjoon.no2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] Q1;
    static int[] Q2;
    static int[] Q3;
    static int[] S;
    static int[] B;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Q1 = new int[N];
        Q2 = new int[N];
        Q3 = new int[N];
        S = new int[N];
        B = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String now = st.nextToken();
            Q1[i] = now.charAt(0) - '0';
            Q2[i] = now.charAt(1) - '0';
            Q3[i] = now.charAt(2) - '0';
            S[i] = st.nextToken().charAt(0) - '0';
            B[i] = st.nextToken().charAt(0) - '0';
        }

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;

                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if(check(i, j, k)) ans++;
                }
            }
        }

        System.out.println(ans);

        br.close();
    }

    static private boolean check(int i, int j, int k) {
        for (int l = 0; l < N; l++) {
            int strike = 0;
            int ball = 0;

            if (i == Q1[l]) strike++;
            if (i == Q2[l]) ball++;
            if (i == Q3[l]) ball++;

            if (j == Q1[l]) ball++;
            if (j == Q2[l]) strike++;
            if (j == Q3[l]) ball++;

            if (k == Q1[l]) ball++;
            if (k == Q2[l]) ball++;
            if (k == Q3[l]) strike++;

            if(strike != S[l] || ball != B[l]){
                return false;
            }
        }

        return true;
    }
}

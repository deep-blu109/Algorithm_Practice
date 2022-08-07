package baekjoon.no3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] top = new int[H+1];
        int[] bot = new int[H+1];
        int min = N;
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            top[Integer.parseInt(br.readLine())]++;
            bot[Integer.parseInt(br.readLine())]++;
        }



        int left = 0;
        int right = H;
        while (left <= right) {
            int mid = (left + right) / 2;
            int bot_mid = H - mid + 1;



        }





    }
}

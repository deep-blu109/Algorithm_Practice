package baekjoon.no4097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N != 0) {
            int[] arr = new int[N + 1];
            int min = 0;
            int result = -10001;

            arr[0] = 0;
            for (int i = 1; i <= N; i++) {
                arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());

                if (arr[i] - min > result) {
                    result = arr[i] - min;
                }
                min = Math.min(min, arr[i]);
            }


            System.out.println(result);

            N = Integer.parseInt(br.readLine());
        }
    }
}

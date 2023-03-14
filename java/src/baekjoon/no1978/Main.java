package baekjoon.no1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = N;
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(input[i]);

            if(now == 1) {
                cnt--;
                continue;
            }

            int size = (int) Math.sqrt(now);

            for (int j = 2; j <= size; j++) {
                if (now % j == 0) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}


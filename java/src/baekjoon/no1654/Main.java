package baekjoon.no1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ans = 1;
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] line = new long[K];

        for (int i = 0; i < K; i++) {
            line[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(line);

        long left = 0;
        long right = line[K - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            if (mid == 0) {
                break;
            }

            for (long l : line) {
                cnt += l / mid;
            }

            if (cnt >= N) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}

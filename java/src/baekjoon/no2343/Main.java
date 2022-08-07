package baekjoon.no2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");

        sum[0] = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + tmp;
            max = Math.max(max, tmp);
        }

        int left = 0;
        int right = N * 10000;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int before = 0;
            int cnt = 0;

            if(max > mid) {
                left = mid + 1;
                continue;
            }

            for(int i = 1; i <= N; i++) {
                if(sum[i] - before > mid) {
                    before = sum[i-1];
                    cnt++;
                }
            }
            cnt++;

            if(cnt > M) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
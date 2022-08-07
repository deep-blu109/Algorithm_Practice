package baekjoon.no16564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] character = new int[N];

        for (int i = 0; i < N; i++) {
            character[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(character);

        int left = character[0];
        int right = character[0] + K;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;

            for(int i = 0; i < N; i++) {
                int tmp = mid - character[i];

                if(tmp > 0) {
                    sum += tmp;
                }
                else {
                    break;
                }
            }

            if(sum > K) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}

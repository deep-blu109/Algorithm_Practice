package baekjoon.no3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int x;
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (left >= x) {
                break;
            }

            int now = arr[left] + arr[right];

            if (now > x) {
                right--;
            } else if (now == x) {
                ans++;
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans);
    }
}

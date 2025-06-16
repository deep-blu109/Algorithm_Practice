package baekjoon.no2470;

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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int sum = 2_000_000_001;
        int leftAns = left;
        int rightAns = right;

        while (left < right) {
            int mid = arr[left] + arr[right];

            if (Math.abs(mid) < Math.abs(sum)) {
                sum = mid;

                leftAns = left;
                rightAns = right;

                if (sum == 0) {
                    break;
                }
            }

            if (mid > 0) {
                right--;
            }
            else if (mid < 0) {
                left++;
            }
        }

        System.out.print(arr[leftAns]);
        System.out.print(" ");
        System.out.println(arr[rightAns]);

        br.close();
    }
}
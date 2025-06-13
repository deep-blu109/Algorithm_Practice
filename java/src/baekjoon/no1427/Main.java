package baekjoon.no1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        char[] nums = new char[N.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = N.charAt(i);
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }

        System.out.println(sb);

        br.close();
    }
}

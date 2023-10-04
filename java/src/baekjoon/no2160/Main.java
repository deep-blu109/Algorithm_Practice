package baekjoon.no2160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N+1];
        int sum = 36;
        int[] ans = new int[2];

        for (int i = 1; i <= N; i++) {
            String now = "";
            for (int j = 0; j < 5; j++) {
                String input = br.readLine();
                for (int k = 0; k < 7; k++) {
                    now += input.charAt(k) == 'X' ? "1" : "0";
                }
            }

            arr[i] = now;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int check = checkNum(arr[i], arr[j]);
                if (sum > check) {
                    sum = check;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int checkNum(String num1, String num2) {
        long bi1 = Long.parseLong(num1, 2);
        long bi2 = Long.parseLong(num2, 2);
        String now = Long.toBinaryString(bi1 ^ bi2);
        int result = 0;

        for(int i = 0; i < now.length(); i++) {
            if(now.charAt(i) == '1') {
                result++;
            }
        }

        return result;
    }
}
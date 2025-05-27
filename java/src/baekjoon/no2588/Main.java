package baekjoon.no2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dividend = Integer.parseInt(br.readLine());
        String divisor = br.readLine();
        int ans = 0;
        int digit = 1;

        for (int i = 0; i < 3; i++) {
            int now = dividend * (divisor.charAt(2 - i) - '0');
            System.out.println(now);

            ans += now * digit;
            digit *= 10;
        }

        System.out.println(ans);
    }
}

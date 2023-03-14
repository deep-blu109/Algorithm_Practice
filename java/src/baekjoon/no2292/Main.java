package baekjoon.no2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 -> 6 -> 12 -> 18 -> 24
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int check = 1;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        while (true) {
            check += cnt * 6;

            if (N <= check) {
                System.out.println(cnt + 1);
                break;
            }

            cnt++;
        }
    }
}

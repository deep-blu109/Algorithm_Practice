package baekjoon.no1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st2;

        int ans = 0;
        int cnt = 0;

        st2 = new StringTokenizer(st1.nextToken(), "+");

        while (st2.hasMoreTokens()) {
            cnt += Integer.parseInt(st2.nextToken());
        }

        ans += cnt;

        while (st1.hasMoreTokens()) {
            st2 = new StringTokenizer(st1.nextToken(), "+");

            cnt = 0;
            while (st2.hasMoreTokens()) {
                cnt += Integer.parseInt(st2.nextToken());
            }

            ans -= cnt;
        }

        System.out.println(ans);
    }
}

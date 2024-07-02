package baekjoon.no14912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int check = i;

            while (check > 0) {
                if(check % 10 == d) {
                    ans++;
                }

                check /= 10;
            }
        }

        System.out.println(ans);
    }
}

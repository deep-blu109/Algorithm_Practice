package baekjoon.no14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = -1_000_000_001;
    static int min = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        calclulate(N, num, operation, 1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static private void calclulate(int N, int[] num, int[] oper, int idx, int ans) {
        if (idx == N) {
            max = Math.max(ans, max);
            min = Math.min(ans, min);

            return;
        }

        int now = num[idx++];


        if (oper[0] > 0) {
            oper[0]--;
            calclulate(N, num, oper, idx, ans + now);
            oper[0]++;
        }

        if (oper[1] > 0) {
            oper[1]--;
            calclulate(N, num, oper, idx, ans - now);
            oper[1]++;
        }

        if (oper[2] > 0) {
            oper[2]--;
            calclulate(N, num, oper, idx, ans * now);
            oper[2]++;
        }

        if (oper[3] > 0) {
            oper[3]--;
            if (ans < 0) {
                ans = (ans * -1) / now * -1;
            } else {
                ans /= now;
            }

            calclulate(N, num, oper, idx, ans);
            oper[3]++;
        }
    }
}

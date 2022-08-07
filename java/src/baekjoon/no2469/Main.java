package baekjoon.no2469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static int n;
    static String[] ladder;
    static int hidden_idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        String result = br.readLine();
        ladder = new String[n+1];
        hidden_idx = 0;

        for(int i = 0; i < n; i++) {
            ladder[i] = br.readLine();
            ladder[i] += "*";

            if(ladder[i].charAt(0) == '?') {
                hidden_idx = i;
            }
        }
        ladder[n] = result;

        for(int i = 0; i < k; i++) {
            char now = (char) ('A' + i);
            boolean flag = false;


            for(int j = 0; j < 3; j++) {
                if(goDown(now, i, i)) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                result = "";
                for(int j = 0; j < k-1; j++) {
                    result += "x";
                }
                System.out.println(result);
                return;
            }
        }

        System.out.println(ladder[hidden_idx]);
    }

    private static boolean goDown(char now, int c, int hidden) {
        String tmp = ladder[hidden_idx];
        int r = 0;

        switch (hidden) {
            case 0:
                if (ladder[hidden_idx].charAt(c) != '?' || ladder[hidden_idx].charAt(c) == '-') {
                    return false;
                }

                if(c != 0) {
                    ladder[hidden_idx] = ladder[hidden_idx].substring(0, c-1);
                }

                ladder[hidden_idx] += "*";
                if(c < k-1) {
                    ladder[hidden_idx] += tmp.substring(c+1, k);
                }

                break;

            case 1:
                if (ladder[hidden_idx].charAt(c) != '?' || ladder[hidden_idx].charAt(c) == '-' || c == k-1) {
                    return false;
                }

                ladder[hidden_idx] = ladder[hidden_idx].substring(0, c-1) +  "*-" + ladder[hidden_idx].substring(c+1, k);
                break;
            case 2:
                if (ladder[hidden_idx].charAt(c) == '-' || ladder[hidden_idx].charAt(c-1) != '?') {
                    return false;
                }

                ladder[hidden_idx] = ladder[hidden_idx].substring(0, c-1) +  "-*";
                if(c < k-1) {
                    ladder[hidden_idx] += tmp.substring(c+1, k);
                }

                break;
        }

        while(r < n-1) {
            if(ladder[r].charAt(c) == '-') {
                c++;
            }
            else if(ladder[r].charAt(c-1) == '-') {
                c--;
            }
            r++;
        }

        if(ladder[r].charAt(c) == now) {
            return true;
        }

        ladder[hidden_idx] = tmp;
        return false;
    }
}

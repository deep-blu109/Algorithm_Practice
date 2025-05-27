package baekjoon.no6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int k = Integer.parseInt(st.nextToken());

        while (k > 0) {
            int[] num = new int[k];

            for (int i = 0; i < k; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            String output = "";

            recursive(0, 0, num, output);
            System.out.println();


            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }


    }

    private static void recursive(int cnt, int idx, int[] num, String output) {
        if (cnt == 6) {

            System.out.println(output);
            return;
        }

        int size = num.length - 6 + cnt;

        for (int i = idx; i <= size; i++) {
            String now = output;
            now += Integer.toString(num[i]) + " ";
            recursive(cnt + 1, i + 1, num, now);
        }
    }
}

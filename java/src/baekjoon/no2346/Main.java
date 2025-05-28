package baekjoon.no2346;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> balloon = new ArrayList<>();
        ArrayList<Integer> pops = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloon.add(i);
            pops.add(Integer.parseInt(st.nextToken()));
        }

        int idx = 0;
        while (!balloon.isEmpty()) {
            sb.append(balloon.remove(idx));
            sb.append(" ");
            int cnt = pops.remove(idx);
            if (--N == 0) break;


            if (cnt > 0) {
                for (int i = 1; i < cnt; i++) {
                    balloon.add(balloon.remove(0));
                    pops.add(pops.remove(0));
                }
            } else {
                for (int i = cnt; i < 0; i++) {
                    balloon.add(0, balloon.remove(N - 1));
                    pops.add(0, pops.remove(N - 1));
                }
            }
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

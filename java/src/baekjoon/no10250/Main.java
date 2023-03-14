package baekjoon.no10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor, ho;

            floor = N % H;
            ho = (floor == 0) ? (N / H) : (N / H + 1);

            if (floor == 0) floor = H;


            String out1 = Integer.toString(floor);
            String out2 = ho < 10 ? "0" + Integer.toString(ho) : Integer.toString(ho);


            System.out.println(out1 + out2);
        }
    }
}

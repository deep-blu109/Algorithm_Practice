package baekjoon.no1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int now = N;


        do {
            cnt++;
            now = (now % 10) * 10 + ((now / 10) + (now % 10)) % 10;

        } while (now != N);

        System.out.println(cnt);
    }
}

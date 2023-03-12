package baekjoon.no1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        if(M == 1) {
            M = 2;
        }

        for(int i = M; i <= N; i++) {
            int size = (int) Math.sqrt(i);
            boolean flag = true;

            for(int j = 2; j <= size; j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                System.out.println(i);
            }
        }
    }
}

package baekjoon.no10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000001;
        int max = -1000001;


        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            min = Math.min(min, input);
            max = Math.max(max, input);
        }

        System.out.println(min + " " + max);
    }
}

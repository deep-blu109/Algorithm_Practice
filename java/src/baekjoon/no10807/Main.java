package baekjoon.no10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = st.nextToken();

            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else map.put(input, 1);
        }

        String now = br.readLine();

        if (map.containsKey(now)) {
            System.out.println(map.get(now));
        } else System.out.println(0);
    }
}

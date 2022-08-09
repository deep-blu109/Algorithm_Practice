package baekjoon.no4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        float cnt = 0;

        String input = "";
        while ((input = br.readLine()) != null) {
            cnt++;

            if(map.containsKey(input) && !input.isEmpty()) {
                map.put(input, map.get(input) + 1);
            }
            else {
                map.put(input, 1);
            }
        }

        for(String key : map.keySet()) {
            System.out.printf("%s %.4f\n", key, map.get(key) / cnt * 100);
        }
    }
}

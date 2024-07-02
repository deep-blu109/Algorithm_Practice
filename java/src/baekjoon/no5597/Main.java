package baekjoon.no5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 30; i++) {
            set.add(i);
        }

        for (int i = 0; i < 28; i++) {
            set.remove(Integer.parseInt(br.readLine()));
        }

        for(int i : set) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

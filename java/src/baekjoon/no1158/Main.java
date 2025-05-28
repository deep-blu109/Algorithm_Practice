package baekjoon.no1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            arrayList.add(i);
        }

        int size = arrayList.size();
        int idx = -1;
        sb.append("<");
        while (arrayList.size() > 1) {
            idx += K;

            while (idx >= size) idx -= size;

            sb.append(arrayList.remove(idx--));
            sb.append(", ");
            size--;
        }

        sb.append(arrayList.remove(0));
        sb.append(">");

        System.out.println(sb.toString());
        br.close();
    }
}

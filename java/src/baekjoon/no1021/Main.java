package baekjoon.no1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arrayList.add(i);
        }

        st = new StringTokenizer(br.readLine());

        int ans = 0;
        while (M-- > 0) {
            int now = Integer.parseInt(st.nextToken());
            int first = arrayList.get(0);

            if (first == now) {
                arrayList.remove(0);
            } else {
                int idx = arrayList.indexOf(now);
                int size = arrayList.size();

                ans += Math.min(idx, size - idx);

                if (idx < size - idx) {
                    for (int i = 0; i < idx; i++) {
                        arrayList.add(arrayList.remove(0));
                    }
                    arrayList.remove(0);
                } else {
                    for (int i = size - 1; i > idx; i--) {
                        arrayList.add(0, arrayList.remove(size-1));
                    }
                    arrayList.remove(size - 1);
                }
            }
        }

        System.out.println(ans);
    }
}

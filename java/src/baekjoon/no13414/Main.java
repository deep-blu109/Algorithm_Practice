package baekjoon.no13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String now = br.readLine();
            map.put(now, cnt++);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        cnt = 1;
        for (String key:keySet) {
            if(cnt++ > K) {
                break;
            }
            System.out.println(key);
        }

        br.close();
    }
}

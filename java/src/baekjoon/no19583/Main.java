package baekjoon.no19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] timeTable = new int[3];
        for(int i = 0; i < 3; i++) {
            timeTable[i] = changeHour(st.nextToken());
        }
        timeTable[1] -= 1;

        String input = "";
        int idx = 0;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            int time = changeHour(st.nextToken());
            String name = st.nextToken();

            while(idx < 3 && time > timeTable[idx]) {
                idx++;
            }

            switch (idx) {
                case 0:
                    map.put(name, false);
                    break;
                case 2:
                    exit(name);
                    break;
            }
        }

        System.out.println(ans);
    }

    private static int changeHour(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");

        int hour = Integer.parseInt(st.nextToken()) * 60;
        int minute = Integer.parseInt(st.nextToken());

        return hour + minute;
    }

    private static void exit(String name) {
        if(map.containsKey(name)) {
            if(!map.get(name)) {
                ans++;
                map.put(name, true);
            }
        }
    }
}

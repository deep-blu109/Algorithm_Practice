package baekjoon.no19637;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Style> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < n; i++){
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            list.add(new Style(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < m; i++){
            s = br.readLine();
            int power = Integer.parseInt(s);

            bw.write(list.get(binarySearch(power)).name + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int binarySearch(int power) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end){
            int mid = (start + end) / 2;

            if(list.get(mid).value >= power){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }


        return end + 1;
    }
    static class Style {
        String name;
        int value;

        public Style(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}

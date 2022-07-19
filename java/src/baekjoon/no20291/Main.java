package baekjoon.no20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>(); // 파일 확장자 별 개수 정리


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            String tmp = st.nextToken(); // 파일명 스킵
            tmp = st.nextToken(); // 확장자명

            // map에 해당 확장자 명이 있는 경우
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) + 1);
            }
            // map에 해당 확장자 명이 없는 경우
            else{
                map.put(tmp, 1);
            }
        }

        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

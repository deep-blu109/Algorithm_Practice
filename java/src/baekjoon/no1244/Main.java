package baekjoon.no1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int switchNum;
    static int[] switch_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        switchNum = Integer.parseInt(br.readLine());
        switch_arr = new int[switchNum];
        int studentNum;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < switchNum; i++){
            switch_arr[i] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < studentNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int button = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                solve1(button);
            }
            else {
                solve2(button);
            }
        }

        for(int i = 0; i < switchNum; i++){
            System.out.printf("%d ", switch_arr[i]);
            if((i+1) % 20 == 0){
                System.out.println();
            }
        }

    }

    private static void solve1(int button) {
        int i = 1;
        while (button * i <= switchNum){
            switch_arr[button * i - 1] = switch_arr[button * i - 1] == 0 ? 1 : 0;
            i++;
        }
    }

    private static void solve2(int button) {
        int i = 0;
        while (button + i <= switchNum && button - i > 0){
            if(switch_arr[button - 1 + i] ==  switch_arr[button - 1 - i]){
                switch_arr[button - 1 + i] = switch_arr[button - 1 + i] == 0 ? 1 : 0;
                switch_arr[button - 1 - i] = switch_arr[button - 1 + i];
                i++;
            }
            else{
                break;
            }
        }
    }
}

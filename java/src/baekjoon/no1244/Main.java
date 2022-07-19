package baekjoon.no1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int switchNum; // 스위치의 개수
    static int[] switch_arr; // 각 스위치의 상태

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        switchNum = Integer.parseInt(br.readLine());
        switch_arr = new int[switchNum];
        int studentNum; // 학생의 수

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < switchNum; i++){
            switch_arr[i] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());

        // 학생의 스위치 조작
        for(int i = 0; i < studentNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken()); // 학생의 성별 1 -> 남자, 2 -> 여자
            int button = Integer.parseInt(st.nextToken()); // 조작을 시작하는 버튼

            // 남자인 경우
            if(gender == 1) {
                solve1(button);
            }
            // 여자인 경우
            else {
                solve2(button);
            }
        }

        // 결과 출력
        for(int i = 0; i < switchNum; i++){
            System.out.printf("%d ", switch_arr[i]);
            // 한줄에 20개가 출력된 경우 다음줄에 출력
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

package baekjoon.no12933;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String record = sc.nextLine(); // 녹음된 소리
        ArrayList<Integer> ducks = new ArrayList<>(); // 오리를 관리할 list

        for(int i = 0; i < record.length(); i++){
            int now = getNum(record.charAt(i)); // 소리를 수로 변경 ex) q -> 1, a -> 3
            boolean flag = false; // 현재 소리를 받을 수 있는 node가 있었는 지 확인

            for(int j = 0; j < ducks.size(); j++){
                // 현재 소리를 받을 수 있는 node가 있던 경우
                if(ducks.get(j) == now-1){
                    ducks.set(j, now); // 현재 소리로 값 변경
                    flag = true;

                    // 현재 값이 5인 경우 -> 0('q'를 받을 수 있는 상태)으로 변경
                    if(ducks.get(j) == 5){
                        ducks.set(j, 0);
                    }

                    break;
                }
            }

            if(!flag){
                //node를 새로 추가해야되는 경우
                if(now == 1){
                    ducks.add(1);
                }
                // 녹음된 소리가 잘못 된 경우
                else{
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 녹음이 잘 된 것인지 확인
        for(int i : ducks){
            if (i > 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ducks.size());
    }

    private static int getNum(char now) {
        int result = 0;

        switch (now) {
            case 'q':
                result =  1;
                break;
            case 'u':
                result = 2;
                break;
            case 'a':
                result = 3;
                break;
            case 'c':
                result = 4;
                break;
            case 'k':
                result = 5;
                break;
        }

        return result;
    }
}

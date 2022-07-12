package baekjoon.no19949;

import java.util.Scanner;

public class Main {
    static int[] answer = new int[10];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            answer[i] = sc.nextInt();
        }

        comb(0, 0, 0, 0);

        System.out.println(ans);
    }

    public static void comb(int cnt, int idx, int num_cnt, int before){
        if (idx == 10){
            if(cnt >= 5){
                ans++;
            }
            return;
        }

        for(int i = 1; i <= 10; i++){
            if(before == i){
                if(num_cnt == 2){
                    continue;
                }

                if(i == answer[idx]){
                    comb(cnt+1, idx+1, num_cnt+1, i);
                }
                comb(cnt, idx+1, num_cnt+1, i);
            }
            else{
                if(i == answer[idx]){
                    comb(cnt+1, idx+1, 1, i);
                }
                comb(cnt, idx+1, 1, i);
            }
        }
    }
}

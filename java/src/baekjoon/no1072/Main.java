package baekjoon.no1072;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();
        int Z = (int)(Y * 100 / X);

        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = 1000000000;
        long ans = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            int now = (int)((Y+mid) * 100 / (X+mid));

            if(now > Z) {
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}

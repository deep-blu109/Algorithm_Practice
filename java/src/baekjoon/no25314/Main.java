package baekjoon.no25314;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String ans = "int";

        for (int i = 0; i < n / 4; i++) {
            ans = "long " + ans;
        }

        System.out.println(ans);
    }
}

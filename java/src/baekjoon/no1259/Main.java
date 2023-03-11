package baekjoon.no1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String now = br.readLine();
        while (!now.equals("0")) {
            int left = 0;
            int right = now.length() - 1;
            boolean flag = true;

            while (left < right) {
                if(now.charAt(left++) != now.charAt(right--)) {
                    flag = false;
                    break;
                }
            }

            if(flag) System.out.println("yes");
            else System.out.println("no");

            now = br.readLine();
        }
    }
}

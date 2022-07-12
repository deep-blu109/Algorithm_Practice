package baekjoon.no19948;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        String poet = sc.nextLine();
        String[] splited = poet.split(" ");
        int spacebar = sc.nextInt();
        int[] english = new int[26];
        StringBuilder result = new StringBuilder();


        for(int i = 0; i < 26; i++){
            english[i] = sc.nextInt();
        }

        if(splited.length-1 > spacebar){
            System.out.println(-1);
            return;
        }


        for(int i = 0; i < splited.length; i++){
            char before = '1';
            for(int j = 0; j < splited[i].length(); j++){
                if(before == splited[i].charAt(j)){
                    continue;
                }

                int now = splited[i].charAt(j) - 'A';
                boolean flag = true;

                if(now > 25){
                    now -= 32;
                    flag = false;
                }

                if(--english[now] < 0){
                    System.out.println(-1);
                    return;
                }

                if(j == 0) {
                    String tmp = Character.toString(flag ? splited[i].charAt(j) : splited[i].charAt(j) - 32);
                    result.append(tmp);
                }

                before = splited[i].charAt(j);
            }
        }

        for(int i = 0; i < result.length(); i++){
            int now = result.charAt(i) - 'A';
            char before = '1';

            if (before == result.charAt(i)){
                continue;
            }

            if(--english[now] < 0){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }
}

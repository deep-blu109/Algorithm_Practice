package baekjoon.no1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] command = new String[N]; // 단축키를 지정할 명령어
        boolean[] alphabet = new boolean[26]; // 해당 알파벳 단축키 지정 여부

        for(int i = 0; i < N; i++) {
            command[i] = br.readLine();
        }

        for(int i = 0; i < N; i++) {
            String now = command[i];
            String[] splited_now = now.split(" "); // 공백 " "을 기준으로 단어 분리
            boolean flag = false; // 1번 조건에 해당하면 true

            // 1번 조건, 단어의 첫글자가 단축키로 가능한지 판별
            for(int j = 0; j < splited_now.length; j++) {
                char alpha = splited_now[j].charAt(0); // 현재 단어의 첫글자
                int alpha_idx = Character.toLowerCase(alpha) - 'a'; // 현재 단어의 첫글자의 알파벳 순서

                // 현재 단어의 첫글자가 단축키로 지정되지 않은 경우
                if(!alphabet[alpha_idx]) {
                    alphabet[alpha_idx] = true; // 단축키 지정
                    splited_now[j] = "[" + Character.toString(alpha) + "]" + splited_now[j].substring(1, splited_now[j].length()); // 현재 글자에 단축키 표시

                    // 단어 합치기
                    String new_command = "";
                    for(String s : splited_now) {
                        new_command += s + " ";
                    }

                    command[i] = new_command; // 명령어 교체
                    flag = true;
                    break;
                }
            }

            // 1번 조건에 해당하지 않은 경우
            if(!flag){
                for(int j = 1; j < now.length(); j++) {
                    char alpha = command[i].charAt(j); // 현재 글자
                    int alpha_idx = Character.toLowerCase(alpha) - 'a';

                    // 현재 위치가 공백인 경우 continue
                    if(alpha == ' ') {
                        continue;
                    }

                    // 현재 글자가 단축키로 지정되지 않은 경우
                    if(!alphabet[alpha_idx]) {
                        command[i] = command[i].substring(0, j) + "[" + Character.toString(alpha) + "]" + command[i].substring(j+1, command[i].length()); // 해당 글자에 단축키 표시
                        alphabet[alpha_idx] = true; // 단축키 지정
                        break;
                    }
                }
            }
        }

        for(String s : command) {
            System.out.println(s);
        }
    }
}

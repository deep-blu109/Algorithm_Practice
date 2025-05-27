package baekjoon.no9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String now = br.readLine();
            Stack stack = new Stack<Character>();
            boolean check = true;

            for (int j = 0; j < now.length(); j++) {
                char c = now.charAt(j);
                if(c == '(') {
                    stack.add(c);
                }
                else {
                    if(stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if(check && stack.isEmpty()) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}

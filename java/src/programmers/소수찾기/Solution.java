package programmers.소수찾기;

import java.util.*;

class Solution {
    private int answer = 0;
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            String now = Character.toString(numbers.charAt(i));

            if(now.equals("0")) continue;

            set.add(Integer.parseInt(now));
            boolean[] check = new boolean[numbers.length()];
            check[i] = true;

            makeNum(check, now, numbers);
        }

        for (int i : set) {
            if(checkPrime(i)) answer++;
        }


        return answer;
    }

    private void makeNum(boolean[] check, String now, String numbers) {
        for(int i = 0; i < numbers.length(); i++) {
            if(check[i]) continue;

            String tmp = new String(now);
            tmp += numbers.charAt(i);
            set.add(Integer.parseInt(tmp));

            check[i] = true;
            makeNum(check, tmp, numbers);
            check[i] = false;
        }
    }

    private boolean checkPrime(int num) {
        if (num == 1) {
            return false;
        }

        int len = num / 2;
        for (int i = 2; i <= len; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}

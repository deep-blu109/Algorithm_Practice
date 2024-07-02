package programmers.전화번호목록;

import java.util.HashSet;
import java.util.Set;


class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"1", "23", "234"}));
    }

    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for (String s : phone_book) {
            set.add(s);
        }

        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                String now = s.substring(0, i);

                if (set.contains(now)) return false;
            }
        }

        return true;
    }
}

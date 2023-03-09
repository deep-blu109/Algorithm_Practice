package programmers.전화번호목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            String s1 = phone_book[i-1].length() <= phone_book[i].length() ? phone_book[i-1] : phone_book[i];
            String s2 = phone_book[i-1].length() > phone_book[i].length() ? phone_book[i-1] : phone_book[i];
            //startswith 함수를 쓰면 좀더 쉽게 풀 수 있음
            int len = s1.length();

            if(s1.equals(s2.substring(0, len))) return false;
        }

        return true;
    }
}

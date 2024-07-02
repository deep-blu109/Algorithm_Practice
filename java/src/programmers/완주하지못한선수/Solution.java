package programmers.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        Map<String, Integer> map = new HashMap<>();


        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : participant) {
            if (map.containsKey(s)) {
                int now = map.get(s);

                if (now == 0) {
                    ans = s;
                } else map.put(s, now - 1);
            } else ans = s;
        }

        return ans;
    }
}

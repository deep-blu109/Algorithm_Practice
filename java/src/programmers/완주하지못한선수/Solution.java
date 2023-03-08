package programmers.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }

        for (String s : participant) {
            if(map.containsKey(s)) {
                int i = map.get(s);

                if(i > 0) {
                    map.put(s, i - 1);
                }
                else {
                    answer = s;
                    break;
                }
            }
            else {
                answer = s;
                break;
            }
        }

        return answer;
    }
}

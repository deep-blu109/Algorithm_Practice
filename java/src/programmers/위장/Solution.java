package programmers.위장;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String now = cloth[1];

            if(map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
            }
            else {
                map.put(now, 1);
            }
        }


        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }

        return answer - 1;
    }
}

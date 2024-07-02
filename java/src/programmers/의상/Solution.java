package programmers.의상;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int ans = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else map.put(cloth[1], 1);
        }

        for (String s : map.keySet()) {
            ans *= map.get(s) + 1;
        }

        return ans - 1;
    }
}

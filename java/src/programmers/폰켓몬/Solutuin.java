package programmers.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int size;

        for (int i : nums) {
            set.add(i);
        }

        size = set.size();

        if (size < nums.length / 2) return size;
        else return nums.length / 2;
    }
}
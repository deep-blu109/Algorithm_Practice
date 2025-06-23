package programmers.모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == arr1[i % 5]) cnt1++;
            if(answers[i] == arr2[i % 8]) cnt2++;
            if(answers[i] == arr3[i % 10]) cnt3++;
        }


        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        List<Integer> list = new ArrayList<>();

        if(cnt1 == max) list.add(1);
        if(cnt2 == max) list.add(2);
        if(cnt3 == max) list.add(3);

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
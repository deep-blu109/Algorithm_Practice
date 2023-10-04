package programmers.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int now = -1;
        Queue<Integer> q = new LinkedList<>();


        for(int i : arr) {
            if(now != i) {
                q.add(i);
                now = i;
            }
        }

        int size = q.size();

        answer = new int[size];

        for(int i = 0 ; i < size; i++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}

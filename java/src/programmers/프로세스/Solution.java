package programmers.프로세스;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int[] array = new int[10];

        for (int priority : priorities) {
            array[priority]++;
            queue.add(priority);
        }

        while (location >= 0) {
            int now = queue.poll();

            if (check(now, array)) {
                answer++;
                array[now]--;
            } else {
                queue.add(now);

                if (location == 0) {
                    location = queue.size();
                }
            }

            location--;
        }

        return answer;
    }

    private boolean check(int now, int[] array) {
        for (int i = 9; i > now; i--) {
            if (array[i] > 0) {
                return false;
            }
        }

        return true;
    }
}

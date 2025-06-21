package programmers.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;

        for (String operation : operations) {
            String[] now = operation.split(" ");

            if (now[0].equals("I")) {
                int addNum = Integer.parseInt(now[1]);
                minQ.add(addNum);
                maxQ.add(addNum);
                cnt++;
            }
            else {
                if(cnt > 0) {
                    if (now[1].equals("1")) {
                        minQ.remove(maxQ.poll());
                    }
                    else {
                        maxQ.remove(minQ.poll());
                    }

                    cnt--;
                }
            }
        }

        if(cnt == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }

        return answer;
    }
}
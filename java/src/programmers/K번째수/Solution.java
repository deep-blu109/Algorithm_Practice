package programmers.K번째수;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int num = commands[i][2] - 1;
            int[] now = Arrays.copyOfRange(array, start, end);

            Arrays.sort(now);

            answer[i] = now[num];
        }

        return answer;
    }
}

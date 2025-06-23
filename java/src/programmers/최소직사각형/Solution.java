package programmers.최소직사각형;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int hor = 0;
        int ver = 0;

        for (int i = 0; i < sizes.length; i++) {
            int nowHor = Math.max(sizes[i][0], sizes[i][1]);
            int nowVer = Math.min(sizes[i][0], sizes[i][1]);

            hor = Math.max(hor, nowHor);
            ver = Math.max(ver, nowVer);
        }

        answer = hor * ver;

        return answer;
    }
}

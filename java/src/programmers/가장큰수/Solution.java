package programmers.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1000, 111, 110, 101, 100, 11, 10, 1, 0}));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = Integer.toString(o1);
                String s2 = Integer.toString(o2);
                boolean check = false;

                if (s1.length() == s2.length()) {
                    return s2.compareTo(s1);
                } else if (s1.length() > s2.length()) {
                    String tmp = s1;
                    s1 = s2;
                    s2 = tmp;
                    check = true;
                }

                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int idx = 1;

                while (c1 == c2) {
                    if (s1.length() == idx) {
                        c2 = s2.charAt(idx);
                        break;
                    }

                    c1 = s1.charAt(idx);
                    c2 = s2.charAt(idx);

                    idx++;
                }

                if (c1 < s1.charAt(0)) c1 = s1.charAt(0);

                if (check) {
                    if (c1 < c2) return -1;
                    return 1;
                } else {
                    if (c1 < c2) return 1;
                    return -1;
                }
            }
        });


        for (int num : nums) {
            answer.append(Integer.toString(num));
        }

        return answer.toString();
    }
}

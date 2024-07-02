package programmers.베스트앨범;

import java.util.*;

public class Solution {
    public static Integer[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, int[]> map2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            int[] arr;
            if (map1.containsKey(genres[i])) {
                map1.put(genres[i], map1.get(genres[i]) + plays[i]);

                arr = map2.get(genres[i]);

                if (plays[arr[0]] < plays[i]) {
                    arr[1] = arr[0];
                    arr[0] = i;
                    map2.put(genres[i], arr);
                } else if (arr[1] == -1) {
                    arr[1] = i;
                    map2.put(genres[i], arr);
                } else if (plays[arr[1]] < plays[i]) {
                    arr[1] = i;
                    map2.put(genres[i], arr);
                }

            } else {
                arr = new int[]{i, -1};

                map1.put(genres[i], plays[i]);
                map2.put(genres[i], arr);
            }
        }

        List<String> keySet = new ArrayList<>(map1.keySet());

        keySet.sort((o1, o2) -> map1.get(o2).compareTo(map1.get(o1)));

        List<Integer> list = new ArrayList<>();

        for (String key : keySet) {
            int[] now = map2.get(key);

            list.add(now[0]);

            if (now[1] > -1) {
                list.add(now[1]);
            }
        }

        return list.toArray(new Integer[0]);
    }
}

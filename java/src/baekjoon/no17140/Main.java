package baekjoon.no17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] A = new int[100][100];
    static int maxRow = 3;
    static int maxColumn = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for (; idx <= 100 && k != A[r][c]; idx++) {
            if (maxRow <= maxColumn) calRow();
            else calColumn();
        }

        if (idx > 100) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(idx);
        }
    }

    private static void calRow() {
        List<List<Map.Entry<Integer, Integer>>> list = new ArrayList<>();

        for (int[] a : A) {
            Map<Integer, Integer> map = new TreeMap<>();

            for (int i : a) {
                if (i != 0) {
                    if (map.containsKey(i)) {
                        map.put(i, map.get(i) + 1);
                    } else {
                        map.put(i, 1);
                    }
                }
            }

            maxRow = Math.max(maxRow, map.size() * 2 > 100 ? 100 : map.size() * 2);

            List<Map.Entry<Integer, Integer>> tmp_list = new ArrayList<>(map.entrySet());

            Collections.sort(tmp_list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            list.add(tmp_list);
        }

        int[][] nextA = new int[100][100];

        for (int i = 0; i < A.length; i++) {
            int idx = 0;

            for (Map.Entry<Integer, Integer> entry : list.get(i)) {
                if(idx >= 100) break;
                nextA[i][idx++] = entry.getKey();

                if(idx >= 100) break;
                nextA[i][idx++] = entry.getValue();
            }
        }

        A = nextA;
    }

    private static void calColumn() {
        List<List<Map.Entry<Integer, Integer>>> list = new ArrayList<>();

        for (int i = 0; i < A[0].length; i++) {
            Map<Integer, Integer> map = new TreeMap<>();

            for (int[] a : A) {
                if (a[i] != 0) {
                    if (map.containsKey(a[i])) {
                        map.put(a[i], map.get(a[i]) + 1);
                    } else {
                        map.put(a[i], 1);
                    }
                }
            }

            maxColumn = Math.max(maxColumn, map.size() * 2 > 100 ? 100 : map.size() * 2);

            List<Map.Entry<Integer, Integer>> tmp_list = new ArrayList<>(map.entrySet());

            Collections.sort(tmp_list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            list.add(tmp_list);
        }

        int[][] nextA = new int[100][100];


        for (int i = 0; i < A[0].length; i++) {
            List<Map.Entry<Integer, Integer>> tmp_list = list.get(i);

            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : tmp_list) {
                if(idx >= 100) break;
                nextA[idx++][i] = entry.getKey();

                if(idx >= 100) break;
                nextA[idx++][i] = entry.getValue();
            }
        }

        A = nextA;
    }
}

package baekjoon.no10916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            int low = lowerBound(cards, key);
            int high = upperBound(cards, key);

            sb.append(high - low).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    public static int lowerBound(int[] cards, int key) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upperBound(int[] cards, int key) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key >= cards[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}

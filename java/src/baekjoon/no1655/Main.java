package baekjoon.no1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int ans = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());

        leftHeap.add(ans);
        System.out.println(ans);

        for (int i = 1; i < cnt; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now > ans) {
                rightHeap.add(now);

                if (rightHeap.size() > leftHeap.size()) {
                    leftHeap.add(rightHeap.poll());
                }
            } else if (now < ans) {
                leftHeap.add(now);
                if (leftHeap.size() >= rightHeap.size() + 2) {
                    rightHeap.add(leftHeap.poll());
                }
            } else {
                if(leftHeap.size() == rightHeap.size()) {
                    leftHeap.add(now);
                } else {
                    rightHeap.add(now);
                }
            }

            ans = leftHeap.element();

            System.out.println(ans);
        }
    }
}

package baekjoon.no13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static class Truck {
        int weight;
        int entry;

        Truck(int weight) {
            this.weight = weight;
        }

        void setEntry(int entry) {
            this.entry = entry;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Truck[] trucks = new Truck[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trucks[i] = new Truck(Integer.parseInt(st.nextToken()));
        }

        Deque<Truck> deque = new ArrayDeque();
        int sum = 0;
        int time = 0;
        int idx = 0;

        while (idx < n) {
            time++;

            if (!deque.isEmpty()) {
                if (time - deque.getFirst().entry == w) {
                    sum -= deque.pollFirst().weight;
                }
            }

            Truck now = trucks[idx];

            if (deque.size() < w && (now.weight + sum <= l)) {
                    sum += now.weight;
                    now.setEntry(time);
                    deque.addLast(now);
                    idx++;
            }
        }

        System.out.print(time + w);

        br.close();
    }
}

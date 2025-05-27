package baekjoon.no2164;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Deque<Integer> cards = new ArrayDeque<>();

        for (int i = 1; i <= num; i++) {
            cards.add(i);
        }

        int check = 0;
        while (cards.size() > 1) {
            if (check++ % 2 == 0) {
                cards.pop();
            }
            else cards.addLast(cards.pollFirst());
        }

        System.out.println(cards.getFirst());
    }
}
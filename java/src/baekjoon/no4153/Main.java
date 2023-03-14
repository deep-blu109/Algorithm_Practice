package baekjoon.no4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] triangle = getTriangle(input);



        while (triangle[0] > 0) {
            if(triangle[0] + triangle[1] == triangle[2]) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }

            input = br.readLine().split(" ");
            triangle = getTriangle(input);
        }
    }

    private static int[] getTriangle(String[] input) {
        int[] triangle = new int[3];

        for (int i = 0; i < 3; i++) {
            triangle[i] = (int) Math.pow(Integer.parseInt(input[i]), 2);
        }

        Arrays.sort(triangle);

        return triangle;
    }
}

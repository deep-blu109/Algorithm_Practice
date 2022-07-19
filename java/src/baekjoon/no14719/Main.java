package baekjoon.no14719;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int result = 0;
        Stack<Integer> blocks = new Stack<>();
        int highest = 0;
        int block;

        for(int i = 0; i < W; i++){
            block = sc.nextInt();

            if(blocks.isEmpty()) {
                if(block != 0) {
                    blocks.push(block);
                    highest = block;
                }
                continue;
            }

            if(block >= highest){
                while (blocks.peek() < highest){
                    result += highest - blocks.pop();
                }
                blocks = new Stack<>();
                blocks.push(block);
                highest = block;
            }
            else{
                blocks.push(block);
            }
        }

        if(!blocks.isEmpty()){
            block = blocks.pop();

            while (!blocks.isEmpty()){
                if(blocks.peek() < block){
                    result += block - blocks.pop();
                }
                else{
                    block = blocks.pop();
                }
            }
        }

        System.out.println(result);
    }
}

package baekjoon.no20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ans = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int size = N*2;
        int[] belt = new int[size+1];
        boolean[] robots = new boolean[size+1];


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= size; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while(K > 0){
            int tmp = belt[size];
            for(int i = size; i > 1; i--){
                belt[i] = belt[i-1];
                robots[i] = robots[i-1];
            }
            belt[1] = tmp;
            robots[1] = false;


            if(robots[N]){
                robots[N] = false;
            }

            for(int i = N; i > 1; i--){
                if(robots[i-1] && !robots[i] && belt[i] > 0){
                    robots[i] = true;
                    robots[i-1] = false;
                    if(--belt[i] == 0){
                        K--;
                    }
                }
            }

            if(robots[N]){
                robots[N] = false;
            }

            if(belt[1] > 0 && !robots[1]){
                robots[1] = true;

                if(--belt[1] == 0){
                    K--;
                }
            }

            ans++;
        }

        System.out.println(ans);
    }
}

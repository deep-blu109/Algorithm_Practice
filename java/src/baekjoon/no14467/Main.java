package baekjoon.no14467;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < N; i++){
            int now = sc.nextInt();
            int location = sc.nextInt();

            if(map.containsKey(now)){
                if(map.get(now) != location){
                    ans++;
                    map.put(now, location);
                }
            }
            else{
                map.put(now, location);
            }
        }

        System.out.println(ans);
    }
}

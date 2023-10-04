package baekjoon.no2160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N + 1];
        int sum = 36;
        int[] ans = new int[2];

        for (int i = 1; i <= N; i++) {
            arr[i] = "";
            for (int j = 0; j < 5; j++) {
                arr[i] += br.readLine();
            }
        }

        for (int i = 1; i < N; i++) {
            int check = 0;
            for (int j = i + 1; j <= N; j++) {
                for(int k = 0 ; k < arr[1].length(); k++) {
                    if(arr[i].charAt(k) != arr[j].charAt(k)) check++;
                }

                if(check < sum){
                    sum = check;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}

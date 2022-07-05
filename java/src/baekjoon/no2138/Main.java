package baekjoon.no2138;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String bulb = br.readLine();
        String expect = br.readLine();
        int[] bulb_arr1 = new int[n];
        int[] bulb_arr2 = new int[n];
        int[] expect_arr = new int[n];

        for(int i = 0; i < n; i++){
            bulb_arr1[i] = bulb.charAt(i) - '0';
            bulb_arr2[i] = bulb.charAt(i) - '0';
            expect_arr[i] = expect.charAt(i) - '0';
        }

        for(int i = 0; i < 2; i++){
            bulb_arr2[i] = 1- bulb_arr2[i];
        }

        int cnt1 = 0;
        int cnt2 = 1;

        for(int i = 1; i < n; i++){
            if(bulb_arr1[i-1] != expect_arr[i-1]){
                bulb_arr1[i-1] = 1- bulb_arr1[i-1];
                bulb_arr1[i] = 1- bulb_arr1[i];
                if(i+1 < n){
                    bulb_arr1[i+1] = 1- bulb_arr1[i+1];
                }

                cnt1++;
            }
            if(bulb_arr2[i-1] != expect_arr[i-1]){
                bulb_arr2[i-1] = 1- bulb_arr2[i-1];
                bulb_arr2[i] = 1- bulb_arr2[i];
                if(i+1 < n){
                    bulb_arr2[i+1] = 1 - bulb_arr2[i+1];
                }

                cnt2++;
            }
        }

        if(bulb_arr1[n-1] != expect_arr[n-1]){
            cnt1 = 100001;
        }
        if(bulb_arr2[n-1] != expect_arr[n-1]){
            cnt2 = 100001;
        }

        if(cnt1 == 100001 && cnt2 == 100001){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(cnt1, cnt2));
        }

    }
}




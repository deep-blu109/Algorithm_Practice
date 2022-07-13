package baekjoon.no21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] order;
    static int[][] student;
    static int[][] classroom;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        order = new int[N*N];
        student = new int[N*N+1][4];
        classroom = new int[N][N];

        for(int i = 0; i < N*N; i++){
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 4; j++){
                student[order[i]][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N*N; i++){
            findSeat(i);
        }

        System.out.println(check());
    }

    private static void findSeat(int now){
        int stu_now = order[now];
        int[] like_stu = {-1, -1, 0, 0}; // 0 : 좋아하는, 1: 비어있는, 2: r, 3: c


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(classroom[i][j] != 0){
                    continue;
                }

                int[] tmp = {0, 0, i, j};

                for(int k = 0; k < 4; k++){
                    int r = i + dr[k];
                    int c = j + dc[k];

                    if(outOfRange(r, c)){
                        continue;
                    }
                    else if(classroom[r][c] == 0){
                        tmp[1]++;
                        continue;
                    }

                    for(int s : student[stu_now]){
                        if(s == classroom[r][c]){
                            tmp[0]++;
                            break;
                        }
                    }
                }

                if(like_stu[0] < tmp[0]){
                    like_stu = tmp;
                }
                else if(like_stu[0] == tmp[0] && like_stu[1] < tmp[1]){
                    like_stu = tmp;
                }
            }
        }

        classroom[like_stu[2]][like_stu[3]] = stu_now;
    }

    private static int check(){
        int result = 0;
        int[] score = {0, 1, 10, 100, 1000};

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int now = classroom[i][j];
                int cnt = 0;

                for(int k  = 0; k < 4; k++){
                    int r = i + dr[k];
                    int c = j + dc[k];

                    if(outOfRange(r, c)){
                        continue;
                    }

                    for(int s : student[now]){
                        if(s == classroom[r][c]){
                            cnt++;
                            break;
                        }
                    }
                }

                result += score[cnt];
            }
        }

        return result;
    }

    private static boolean outOfRange(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return true;
        }
        return false;
    }
}

package baekjoon.no10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Member {
        int idx;
        int age;
        String name;

        Member (int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] =  new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(members, (o1, o2) -> {
            if(o1.age == o2.age) {
                return o1.idx - o2.idx;
            }

            return o1.age - o2.age;
        });

        for(int i = 0; i < N; i++) {
            System.out.println(members[i].age + " " + members[i].name);
        }
    }
}

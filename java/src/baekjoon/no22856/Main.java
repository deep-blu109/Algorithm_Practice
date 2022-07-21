package baekjoon.no22856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static int N;
    static int ans = 0;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int value = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[value] = new Node(left, right);
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        N--;
        inorder(1, false);

        System.out.println(ans);
    }


    private static void inorder(int now, boolean flag) {
        Node node = tree[now];

        if(node.left != -1){
            ans++;
            N--;
            inorder(node.left, flag);
            node.left = -1;
        }

        if(now == 1) {
            flag = true;
        }

        if(node.right != -1){
            ans++;
            N--;
            inorder(node.right, flag);
            node.right = -1;
        }

        if(now != 1 && (N > 0 || !flag)){
            ans++;
        }
    }
}

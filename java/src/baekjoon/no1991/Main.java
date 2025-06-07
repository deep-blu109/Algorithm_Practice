package baekjoon.no1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Tree {
        public static class Node {
            char root;
            Node left;
            Node right;

            public Node(char root) {
                this.root = root;
                left = null;
                right = null;
            }

            public void addLeft(Node left) {
                this.left = left;
            }

            public void addRight(Node right) {
                this.right = right;
            }
        }

        public Node addNode(char root) {
            return new Node(root);
        }

        public String preOrder(Node node, String ans) {
            if (node == null) {
                return ans;
            }

            ans += node.root;

            return preOrder(node.right, preOrder(node.left, ans));
        }

        public String inOrder(Node node, String ans) {
            if (node == null) {
                return ans;
            }

            ans = inOrder(node.left, ans);
            ans += node.root;
            return inOrder(node.right, ans);
        }

        public String postOrder(Node node, String ans) {
            if (node == null) {
                return ans;
            }

            ans = postOrder(node.left, ans);
            ans = postOrder(node.right, ans);
            ans += node.root;
            return ans;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        Tree tree = new Tree();
        ArrayList<Tree.Node> arrayList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            arrayList.add(tree.addNode((char) (i + 'A')));
        }

        for (int i = 0; i < cnt; i++) {
            String now = br.readLine();
            char left = now.charAt(2);
            char right = now.charAt(4);

            Tree.Node root = arrayList.get(now.charAt(0) - 'A');

            if (left != '.') {
                root.addLeft(arrayList.get(left - 'A'));
            }

            if (right != '.') {
                root.addRight(arrayList.get(right - 'A'));
            }
        }

        System.out.println(tree.preOrder(arrayList.get(0), ""));
        System.out.println(tree.inOrder(arrayList.get(0), ""));
        System.out.println(tree.postOrder(arrayList.get(0), ""));

        br.close();
    }
}

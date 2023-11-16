package Bkj_1167_ver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int length = 0, far = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //트리 입력받기
        tree = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            tree[i] = new ArrayList<>();
        }

        int idx, t;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                t = Integer.parseInt(st.nextToken()) - 1;
                if (t == -2) break;
                tree[idx].add(new Node(t, Integer.parseInt(st.nextToken())));
            }
        }

        //임의의 노드에서 dfs 실시
        visit = new boolean[V];
        dfs(0);

        //임의의 노드에서 가장 먼 노드에서 dfs 실시하여 최대 지름 구하기
        length = 0;
        visit = new boolean[V];
        dfs(far);

        System.out.println(length);
    }

    private static void dfs(int u) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(u, 0));

        Node pop;
        while (!stack.isEmpty()) {
            pop = stack.pop();
            visit[pop.n] = true;
//                System.out.println("u:" + (pop.n + 1) + " l:" + (pop.l));

            if (pop.l > length) {
                length = pop.l;
                far = pop.n;
//                    System.out.println("V:" + (result.n + 1) + " R:" + result.l);
            }

            for (Node n : tree[pop.n]) {
                if (!visit[n.n]) {
                    stack.push(new Node(n.n, pop.l + n.l));
                }
            }
        }
    }

}

class Node {
    int n;
    int l;

    public Node(int n, int l) {
        this.n = n;
        this.l = l;
    }
}





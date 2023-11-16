package Bkj_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int result = 0, far = 0;

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
            //이런 ㅂ같은 입력에서의 안일함때문에 몇 시간을 날렸다.
            idx = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                t = Integer.parseInt(st.nextToken()) - 1;
                if (t == -2) break;
                tree[idx].add(new Node(t, Integer.parseInt(st.nextToken())));
            }
        }

        visit = new boolean[V];
        //임의의 노드에서 dfs 실시
        dfs(0,0);

        //임의의 노드에서 가장 먼 노드에서 dfs 실시하여 최대 지름 구하기
        result = 0;
        visit = new boolean[V];
        dfs(far,0);

        System.out.println(result);
    }

    private static void dfs(int u, int l) {
        visit[u] = true;
        if (l > result) {
            result = l;
            far = u;
//                    System.out.println("V:" + (v + 1) + " R:" + r);
        }

//                for (int i = 0; i < visit.length; i++) {
//                    System.out.print((visit[i] ? 1 : 0) + " ");
//                }
//                System.out.println();
//                System.out.println();

        for (Node node : tree[u]) {
            if (!visit[node.v]) {
//                System.out.println((u + 1) + "-" + (edge.v + 1) + " l:" + (l + edge.w));
                dfs(node.v, l + node.w);
            }
        }
    }

}

class Node {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}





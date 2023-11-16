//어디가 문젠지 확인
package Bkj_1504;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) -1;
            int v = Integer.parseInt(st.nextToken()) -1;
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
//        System.out.println();
//        for (int i = 0; i < N; i++) {
//            for (Edge var : graph[i]) {
//                System.out.println((i+1)+" "+(var.v+1)+" "+var.w);
//            }
//            System.out.println();
//        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        int result = Math.min((dijkstra(0, v1) + dijkstra(v2, N - 1)), (dijkstra(0, v2) + dijkstra(v1, N - 1))) + dijkstra(v1, v2);
        System.out.println(result == 0 ? -1 : result);
    }

    private static int dijkstra(int u, int v) {
//        System.out.println("d: " + (u+1) + " " + (v+1));
        int spl = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node[] sp = new Node[N];
        boolean[] visited = new boolean[N];

        //각 노드의 sp를 infinite로 설정
        for (int i = 0; i < N; i++) {
            sp[i] = new Node(i, Integer.MAX_VALUE);
//            System.out.println((sp[i].n+1) +" "+ sp[i].sp);
        }
//        System.out.println("----------------------------");
        sp[u].sp = 0;
        visited[u] = true;
        //u에 연결된 노드들 가중치로 설정
        for (int i = 0; i < graph[u].size(); i++) sp[graph[u].get(i).v].sp = graph[u].get(i).w;
        //u가
        for (int i = 0; i < graph[u].size(); i++) {
            if (i != u) pq.add(sp[i]);
//            System.out.println((sp[i].n+1) +" "+ sp[i].sp);
        }

//        System.out.println("----------------------------");
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            if (visited[p.n]) continue;
            visited[p.n] = true;
//            System.out.println((p.n+1) + " " + p.sp);
            if (p.n == v) {
                spl = p.sp;
                break;
            }
            for (int i = 0; i < graph[p.n].size(); i++) {
                if (graph[p.n].get(i).v != u) {
                    sp[graph[p.n].get(i).v].sp = Math.min(p.sp + graph[p.n].get(i).w, sp[graph[p.n].get(i).v].sp);
                    pq.add(sp[graph[p.n].get(i).v]);
                }
            }
        }
//        System.out.println();
        return spl;
    }
}

class Edge {
    int v;
    int w;


    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

}

class Node implements Comparable<Node> {
    int n;
    int sp;

    public Node(int n, int sp) {
        this.n = n;
        this.sp = sp;
    }

    @Override
    public int compareTo(Node o) {
        return this.sp - o.sp;
    }
}
/*
최단경로는
u - v1 - v2 - v
or
u - v2 - v1 - v

l1 = (u - v1) + (v2 - v) 최소길이
l2 = (u - v2) + (v1 - v) 최소길이
두 정점을 지나는 최소길이 : min(l1, l2) + (v1 - v2) 최소길이
 */
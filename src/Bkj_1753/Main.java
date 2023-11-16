package Bkj_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E, K;
    static List<Node>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;

        //Node 클래스List를 저장하는 배열 생성
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            graph[idx].add(
                    new Node(Integer.parseInt(st.nextToken()) - 1
                            , Integer.parseInt(st.nextToken())));
        }

        //최단 경로값 저장하는 배열 result
        result = new int[V];
        for (int i = 0; i < V; i++) result[i] = Integer.MAX_VALUE;
        result[K] = 0;

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int r : result){
            if (r == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(r);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int K) {
        //Queue에 정점K 삽입
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //정점 방문 여부 확인 배열
        boolean[] visit = new boolean[V];
        queue.add(new Node(K, 0));

        //Queue에서 빼낸 정점과 연결된 간선에서 result보다 경로가 짧은 경우 저장
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            if (visit[poll.v]) continue;
            visit[poll.v] = true;

            for (Node e : graph[poll.v]) {
                result[e.v] = Math.min(result[e.v], result[poll.v] + e.w);
                queue.add(new Node(e.v, result[e.v]));
            }
        }
    }
}


class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}
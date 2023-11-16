package Bkj_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, minW = 0;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //입력 그래프
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList();

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u - 1].add(new Edge(v, w));
            graph[v - 1].add(new Edge(u, w));
        }

        PrimAlgorithm();

        System.out.println(minW);

    }

    public static void PrimAlgorithm() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V];

        //임의의 Vertex 1에 연결된 모든 Edges를 PriorityQueue에 삽입
        for (Edge e: graph[0]) pq.add(e);
        visit[0] = true;
        int count = 1;

        //모든 Vertices가 연결되면 반복 종료
        Edge p;
        while (count < V) {
            p = pq.poll();
            if (visit[p.v - 1]) continue;

            //pq에서 뽑은 Edge가 향하는 v를 처음 방문한다면 해당 v에 연결된 모든 Edges를 pq에 삽입
            for (Edge e: graph[p.v - 1]) pq.add(e);
            visit[p.v - 1] = true;
            count++;
            minW += p.w;
        }
    }
}

//가중치를 갖는 directed edge
class Edge implements Comparable<Edge>{
    int v;
    int w;

    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    //PriorityQueue에서 가중치 w를 기준으로 정렬할 수 있도록 메소드 Override
    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}
/*
4 5
1 2 3
2 3 2
3 4 4
4 1 1
2 4 5

 */

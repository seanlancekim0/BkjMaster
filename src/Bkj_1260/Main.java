package Bkj_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken()),
                V = Integer.parseInt(st.nextToken());

        boolean[][] edge = new boolean[10001][10001];
        boolean[] visit = new boolean[1001];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edge[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        System.out.println(DFS(edge, visit, V , N + 1, M));
        visit = new boolean[N + 1];
        System.out.println(BFS(edge, visit, V, N + 1, M));
    }

    private static String DFS(boolean[][] edge, boolean[] visit, int v, int n, int m) {
        String result = "";

        visit[v] = true;
        result += v;

        for(int i = 1; i < n; i++) {
            if (edge[v][i] && !visit[i]) {
                result += DFS(edge, visit, i, n, m);
            }
        }
        return result;
    }

    private static String BFS(boolean[][] edge, boolean[] visit, int v, int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        String result = "";

        queue.offer(v);
        visit[v] = true;
        result += v;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i = 1; i < n; i++) {
                if (edge[temp][i] && !visit[i]) {
                    queue.offer(i);

                    visit[i] = true;
                    result += i;
                }
            }
        }


        return result;
    }

}

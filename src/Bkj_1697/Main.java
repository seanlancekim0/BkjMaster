package Bkj_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        bfs(N, K);

        System.out.println(sb);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[Math.max(n, k) + 2];
        queue.add(n);
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int count = queue.poll();
            visit[cur] = true;
            if (cur == k) {
                sb.append(count);
                break;
            }
            if (cur - 1 >= 0 && !visit[cur - 1]) {
                queue.add(cur - 1);
                queue.add(count + 1);
            }
            if (cur + 1 < visit.length && !visit[cur + 1]) {
                queue.add(cur + 1);
                queue.add(count + 1);
            }
            if (cur * 2 < visit.length && !visit[cur * 2]) {
                queue.add(cur * 2);
                queue.add(count + 1);
            }
        }
    }

}

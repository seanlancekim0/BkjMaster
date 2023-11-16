package Bkj_14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Dot> queue = new LinkedList<>();
    static int n, m;
    static int[][] map;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[i][j] = Integer.MAX_VALUE;

        Dot target = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) target = new Dot(i, j, -1);
            }
        }
        queue.add(target);

        while (!queue.isEmpty()) {
            Dot p = queue.poll();
//            System.out.println("i: " + p.i + ", j: " + p.j + ", v: " + p.preVal);
            bfs(p.i, p.j, p.preVal + 1);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    if (map[i][j] == 0) System.out.print(0 + " ");
                    else System.out.print(-1 + " ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    private static void bfs(int i, int j, int v) {
        if (i < 0 || i >= n || j < 0 || j >= m || map[i][j] == 0 || result[i][j] <= v) return;
        result[i][j] = v;
        queue.add(new Dot(i + 1, j, v));
        queue.add(new Dot(i - 1, j, v));
        queue.add(new Dot(i, j + 1, v));
        queue.add(new Dot(i, j - 1, v));
    }
}
class Dot {
    int i;
    int j;
    int preVal;

    public Dot(int i, int j, int preVal) {
        this.i = i;
        this.j = j;
        this.preVal = preVal;
    }
}

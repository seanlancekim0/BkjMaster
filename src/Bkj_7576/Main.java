package Bkj_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box;
    static ArrayList<Node> riped = new ArrayList<>();
    static Queue<Node> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    riped.add(new Node(i, j, 0));
                    box[i][j] = 0;
                }
            }
        }

        for (Node n : riped) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            System.out.println("x: " + p.x + ", y: " + p.y + ", lvl: " + p.level);
            dfs(p);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(Node p) {
        if (p.x < 0 || p.x >= M || p.y < 0 || p.y >= N || box[p.x][p.y] == -1 || box[p.x][p.y] == 1) return;
        if (count < p.level) count = p.level;
        box[p.x][p.y] = 1;
        p.level++;
        queue.add(new Node(p.x + 1, p.y, p.level));
        queue.add(new Node(p.x - 1, p.y, p.level));
        queue.add(new Node(p.x, p.y + 1, p.level));
        queue.add(new Node(p.x, p.y - 1, p.level));
    }
}

class Node {
    int x;
    int y;
    int level;

    public Node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

package Bkj_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//이해해라
public class Main {
    static int N, M, answer, min;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //그래프 입력받기
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        answer = 0;
        min = Integer.MAX_VALUE;

//        for (int i = 1; i <= N; i++) {
//            check = new boolean[N + 1];
//            cabinNum = 0;
//            queue.add(new Node(i, 0));
//
//            while (!queue.isEmpty()) {
//                Node n = queue.poll();
//                List<Integer> curList = list[n.e];
//                for (int l = 0; l < curList.size(); l++) {
//                    if(check[curList.get(l)]) continue;
//                    check[curList.get(l)] = true;
//                    cabinNum+=n.cnt+1;
//                    queue.add(new Node(curList.get(l), n.cnt+1));
//                }
//            }
//
//            if(cabinNum < min) {
//                min = cabinNum;
//                answer = i;
//            }
//        }
        for (int i = 1; i <= N; i++) {
            bfs(i);
//            System.out.println();
        }
        System.out.println(answer);
    }

    private static void bfs(int root) {
        Queue<Node> queue = new LinkedList<>();
        int cabinNum = 0, count = 0;
        boolean[] visit = new boolean[N];
        queue.add(new Node(root, count));

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            visit[p.e - 1] = true;
            cabinNum += p.cnt++;
//            System.out.println(p.e + " "+cabinNum);
            for (int l : list[p.e]) {
                if (!visit[l - 1]) queue.add(new Node(l, p.cnt));
            }
        }
        if (cabinNum < min) {
            min = cabinNum;
            answer = root;
//            System.out.println(min +","+answer);
        }
    }

    static class Node {
        int e, cnt;

        Node(int e, int cnt) {
            this.e = e;
            this.cnt = cnt;
        }
    }
}
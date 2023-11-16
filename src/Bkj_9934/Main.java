package Bkj_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> arr = new ArrayList<>();
    //깊이 K를 변경시키기 위한 변수
    static int count = 0, c = 0;
    //BFS(넓이우선탐색)하기 위한 Queue
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) arr.add(Integer.parseInt(st.nextToken()));

        BFS(K, arr.size() / 2);

        System.out.println(sb);
    }

    public static void BFS(int K, int idx) {
        if(K == 0) return;
        sb.append(arr.get(idx) + " ");

        //idx노드의 자식노드 2개의 index를 queue에 add함
        queue.add(idx - (int)Math.pow(2, K - 2));
        queue.add(idx + (int)Math.pow(2, K - 2));

        if(++count >= (int)Math.pow(2, c)) {
            count = 0;
            K--;
            c++;
            sb.append("\n");
        }
        if (!queue.isEmpty()) BFS(K, queue.poll());

    }
}
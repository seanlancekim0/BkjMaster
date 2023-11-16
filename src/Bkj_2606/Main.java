package Bkj_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int[] virus;

    static ArrayList<ArrayList<Integer>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());
        virus = new int[n + 1];
        virus[1] = 1;

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken());
            if (graph.get(a) == null){
                graph.set(a, new ArrayList(b));
            } else graph.get(a).add(b);
            if (graph.get(b) == null){
                graph.set(b, new ArrayList(a));
            } else graph.get(b).add(a);
        }
        //그래프를 구성하고 dfs탐색 실행
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int a) {
        for (int i = 0; i < graph.get(a).size(); i++) {
            int index = graph.get(a).get(i);
            //index가 감염되지 않았으면 감염시키고 dfs(index)메소드를 실행
            if (virus[index] == 0) {
                count++;
                virus[index] = 1;
                dfs(index);
            }
        }
    }
}

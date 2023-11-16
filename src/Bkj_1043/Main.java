package Bkj_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] truth;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 0;
        truth = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        ArrayList<Integer>[] arr = new ArrayList[M + 1];
        for (int i = 0; i <= M; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for (int j = 0; j < l; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        boolean[][] visit = new boolean[N + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j < arr[i].size() - 1; j++) {
                for (int k = j + 1; k < arr[i].size(); k++) {
                    if (visit[j][k]) break;
                    graph[arr[i].get(j)].add(arr[i].get(k));
                    visit[arr[i].get(j)][arr[i].get(k)] = true;
                    graph[arr[i].get(k)].add(arr[i].get(j));
                    visit[arr[i].get(k)][arr[i].get(j)] = true;
                }
            }
        }

        if (!arr[0].isEmpty()) dfs(arr[0].get(0));
//        truth[arr[0].get(0)] = true;

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                if (truth[arr[i].get(j)]) {
                    break;
                }
                if (j == arr[i].size() - 1) count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(Integer input) {
        if (truth[input]) return;
        truth[input] = true;
//        System.out.println("truth[" + input + "]: "+ truth[input]);
        for (int i = 0; i < graph[input].size(); i++) {
            dfs(graph[input].get(i));
        }
    }
}

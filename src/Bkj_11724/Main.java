package Bkj_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Root{
            int val;
            Root(int val) {
                this.val = val;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        Root 클래스를 갖는 DisjointSet
        Root[] DJS = new Root[N + 1];
        for (int i = 1; i <= N; i++) DJS[i] = new Root(0);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int min = Math.min(u, v);
            int max = Math.max(u, v);

            if (DJS[min].val == 0 && DJS[max].val == 0) {
                Root root = new Root(max);
                DJS[min] = root;
                DJS[max] = root;
            } else if (DJS[min].val != 0 && DJS[max].val == 0) {
                DJS[max] = DJS[min];
                if (DJS[min].val < max) DJS[min].val = max;
            } else if (DJS[min].val == 0 && DJS[max].val != 0) {
                DJS[min] = DJS[max];
                if (DJS[max].val < max) DJS[max].val = max;
            } else {
                DJS[max].val = Math.max(Math.max(DJS[min].val, DJS[max].val), max);
                for (int j = 1; j <= N; j++) if (DJS[j].equals(DJS[min])) DJS[j] = DJS[max];
            }
        }

        int count = 0;
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (DJS[i].val == 0 || arr[DJS[i].val] == 0) {
                count++;
                arr[DJS[i].val]++;
            }
        }
        System.out.println(count);
    }
}

package Bkj_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Long> map = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        map.add(0L);
        for (int k = 1; k <= N; k++) map.add(map.get(k - 1) + Integer.parseInt(st.nextToken()));

        int i, j;
        //O(M)
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sb.append(map.get(j) - map.get(i - 1)).append("\n");
        }

        System.out.print(sb);
    }
}

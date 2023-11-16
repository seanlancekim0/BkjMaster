package Bkj_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) arr.add(i);

        int order = K - 1;
        StringBuilder sb = new StringBuilder("<");
        sb.append(K);

        for (int i = 1; i < N; i++) {
            arr.remove(order);
            order = (order + K - 1) % arr.size();
            sb.append(", ").append(arr.get(order));
        }
        sb.append(">");
        System.out.print(sb);
    }
}

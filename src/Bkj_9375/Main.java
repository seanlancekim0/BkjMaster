package Bkj_9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<String> str = new ArrayList<>();
            ArrayList<Integer> arr = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                String part = st.nextToken();
                int index = str.indexOf(part);

                if (!str.contains(part)) {
                    str.add(part);
                    arr.add(1);
                }
                else arr.set(index, arr.get(index) + 1);
            }
            int result = 1;
            for (int val : arr) result *= val + 1;
            sb.append(--result).append("\n");
        }
        System.out.println(sb);
    }
}
/*
head eye    2 1
3 2 1
 */
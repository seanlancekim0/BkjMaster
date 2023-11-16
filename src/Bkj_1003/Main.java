package Bkj_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[][] arr = { {0, 0}, {1, 0}, {0, 1}};

            int N = Integer.parseInt(br.readLine());
            int j = 0;
            for (; j < N; j++) {
                arr[j % 3][0] = arr[(j + 1) % 3][0] + arr[(j + 2) % 3][0];
                arr[j % 3][1] = arr[(j + 1) % 3][1] + arr[(j + 2) % 3][1];
            }
            sb.append(arr[(j + 1) % 3][0]).append(" ").append(arr[(j + 1) % 3][1]).append("\n");
        }
        System.out.println(sb);
    }
}

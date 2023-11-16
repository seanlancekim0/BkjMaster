package Bkj_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int[] dp = new int[4];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            int n = Integer.parseInt(br.readLine());
            if (n < 4){
                sb.append(dp[n - 1]).append("\n");
                continue;
            }

            int j;
            for (j = 3; j < n; j++) {
                dp[j % 4] = dp[(j + 1) % 4] + dp[(j + 2) % 4] + dp[(j + 3) % 4];
            }
            sb.append(dp[(j - 1) % 4]).append("\n");
        }
        System.out.println(sb);
    }
}
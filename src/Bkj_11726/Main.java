package Bkj_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
//            System.out.println("dp[" + i + "] = " + dp[i]);
        }
        System.out.println(dp[n]);
    }
}
/*
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수
 = n을 1, 2로 채우는 방법의 수
 n = 2*k (+ 1)

 1: 1
 2: 2 = 2C0 + 1C1
 3: 3 = 3C0 + 2C1
 4: 4C0 + 3C1 + 2C2 = 5
 5: 5C0 + 4C1 + 3C2 = 8
 6: 13
 n: nC0 + n-1C1 + ... + n-kCk (n-k >= k)
 */
package Bkj_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int dp[] = new int[X + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= X; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        System.out.println(dp[X]);
    }
}
/*
        123
1   0   000
2   1   010
3   1   001
4   2   020
5   3   120
6   2   011
7   3   111
8   3   030
9   2   002
10  3   102
11  4   202
12  3   021
13  4   121
14  4   121
 */
package Bkj_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //index 접근 편리하게 / i - 3인덱스 접근을 위해서 배열 크기는 N + 1로 지정함.
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];

        // N이 1인 경우에dp[2]에 접근할 수 없어서 조건문 필요
        if(N>=2) dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];

        System.out.println(dp[N]);
    }
}
/*  dp
10  10
20  30
15
25
10
20
 */
/*
1 1
2 12
3 13 23
4 124 134 24
5 1245 135 235 245
6
7
8

 */

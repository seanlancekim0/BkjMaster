package Bkj_17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //최소 제곱수의 합을 저장할 배열 dp
        int [] dp = new int[n + 1];
        int a = 1;
        //1부터 n까지 제곱수들의 최소 개수 저장
        for (int i = 1; i <= n; i++) {
            //i가 제곱수인 경우 1을 저장
            if (i == a * a) {
                dp[i] = 1;
                a++;
            }
            else {
                //제곱수 합의 최댓값은 4
                dp[i] = 4;
                //제곱수 + (n - 제곱수)의 경우로 쪼개어서 저장된 dp배열을 참조
                for (int j = 1; j < a; j++)
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
            }
        }
        System.out.println(dp[n]);
    }
}
/*
dp
f(n) = f(a) + f(b) // f(c) + f(d) + f(e)
 */
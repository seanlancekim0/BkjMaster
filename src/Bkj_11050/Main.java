package Bkj_11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        if (K < 0 && K > N)System.out.println(0);
        else System.out.println(fact(N) / fact(K) / fact(N - K));
    }

    public static int fact(int n) {
        int result = 1;
        while (n > 1) result *= n--;
        return result;
    }
}

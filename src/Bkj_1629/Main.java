package Bkj_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(mod(A, B));

    }

    private static long mod(long a, long b) {
        //지수가 1일 때
        if(b == 1) return a % C;

        long temp = mod(a, b / 2);

        return (b % 2 == 1) ? (temp * temp % C) * a % C : temp * temp % C;
    }
}
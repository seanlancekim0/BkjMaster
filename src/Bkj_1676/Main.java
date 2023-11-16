package Bkj_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int temp, two = 0, five = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fact(N);
        System.out.println(Math.min(two, five));
    }

    public static void fact(int n) {
        if (n <= 1) return;
        temp = n;

        while (temp != 0 && temp % 5 == 0) {
            five++;
            temp /= 5;
        }
        while (temp != 0 && temp % 2 == 0) {
            two++;
            temp /= 2;
        }
        fact(n - 1);
    }
}
/*
10! =
 */
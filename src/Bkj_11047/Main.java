package Bkj_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) arr.add(Integer.parseInt(br.readLine()));

        arr.sort(Collections.reverseOrder());
        int count = 0;
        for (int a : arr)
            if (a <= K) {
                count += K / a;
                K %= a;
            }

        System.out.println(count);
    }
}

package Bkj_2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int abc = Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        while (abc != 0) {
            arr[abc % 10]++;
            abc /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) sb.append(a).append("\n");
        System.out.println(sb);
    }
}

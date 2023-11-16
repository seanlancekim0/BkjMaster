package Bkj_1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while (!str.equals("0")) {
            if (str.substring(0, str.length() / 2).equals(
                    new StringBuilder(str.substring(str.length() / 2 + str.length() % 2)).reverse().toString()))
                sb.append("yes\n");
            else sb.append("no\n");
            str = br.readLine();
        }

        System.out.println(sb);
    }
}

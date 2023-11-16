package Bkj_2744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //대문자
            if (c < 'a') c = (char) (c - 'A' + 'a');
            //소문자
            else c = (char) (c - 'a' + 'A');
            sb.append(c);
        }

        System.out.println(sb);
    }
}

package Bkj_1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while (!str.equals("#")) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i)))
                    count++;
            }
            sb.append(count).append("\n");
            str = br.readLine();
        }

        System.out.print(sb);
    }
}

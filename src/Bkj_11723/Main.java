package Bkj_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str, x;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            if(st.hasMoreTokens()) {
                x = st.nextToken();
                switch (str) {
                    case "add" -> set.add(x);
                    case "remove" -> set.remove(x);
                    case "check" -> sb.append(set.contains(x) ? 1 : 0).append("\n");
                    case "toggle" -> {
                        if (set.contains(x)) set.remove(x);
                        else set.add(x);
                    }
                }
            }
            else switch (str) {
                case "all" -> {
                    for (int j = 1; j <= 20; j++) set.add(j + "");
                }
                case "empty" -> set.clear();
            }
        }
        System.out.println(sb);
    }
}

package Bkj_4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while (!str.equals("0 0 0")) {
            st = new StringTokenizer(str);
            int[] tc = new int[3];
            for (int i = 0; i < 3; i++) tc[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 3; i++) {
                if (Math.pow(tc[i % 3], 2) == Math.pow(tc[(i + 1) % 3], 2) + Math.pow(tc[(i + 2) % 3], 2)) {
                    sb.append("right").append("\n");
                    break;
                }else if (i == 2)
                    sb.append("wrong").append("\n");
            }
            str = br.readLine();
        }
        System.out.println(sb);
    }
}

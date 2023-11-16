package Bkj_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int differ;
        if (start == 1) differ = 1;
        else if (start == 8) differ = -1;
        else {
            System.out.println("mixed");
            return;
        }
        for (int i = 0; i < 7; i++) {
            if (Integer.parseInt(st.nextToken()) - start != differ) {
                System.out.println("mixed");
                return;
            }
            start += differ;
        }
        System.out.println(differ == 1 ? "ascending" : "descending");
    }
}

package Bkj_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()),
                r = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken()),
                size = (int)Math.pow(2, N);

        System.out.println(zSearch(size, r, c));
    }

    private static int zSearch(int size, int r, int c) {
        int sum = 0;

        if (size == 1) {
            return 0;
        }
        size /= 2;
        if (r < size && c < size) {
            sum += zSearch(size, r, c);
        }
        else if (r < size && c >= size) {
            sum += size * size + zSearch(size, r, c - size);
        }
        else if (r >= size && c < size) {
            sum += size * size * 2 + zSearch(size, r - size, c);
        }
        else if (r >= size && c >= size) {
            sum += size * size * 3 + zSearch(size, r - size, c - size);
        }
        return sum;
    }
}

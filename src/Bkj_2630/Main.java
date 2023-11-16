package Bkj_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) paper[i][j] = st.nextToken().equals("1");
        }

        slice(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void slice(int r, int c, int n) {
        boolean b = paper[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //처음 색과 다른 색이 나오면 즉시 4등분하여 다시 검사한다
                if (b ^ paper[r + i][c + j]) {
                    n /= 2;
                    slice(r, c, n);
                    slice(r + n, c, n);
                    slice(r, c + n, n);
                    slice(r + n, c + n, n);
                    return;
                }
            }
        }

        //확인한 구간의 색이 모두 같으면 색깔에 따라 종이의 개수를 추가한다
        if (paper[r][c]) blue++;
        else white++;
    }
}
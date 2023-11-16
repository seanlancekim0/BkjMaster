package Bkj_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Cost = new int[N][3];
        DP = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Cost[i][0] = Integer.parseInt(st.nextToken());
            Cost[i][1] = Integer.parseInt(st.nextToken());
            Cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        DP[0][0] = Cost[0][0];
        DP[0][1] = Cost[0][1];
        DP[0][2] = Cost[0][2];


        System.out.print(Math.min(cost(N - 1, 0), Math.min(cost(N - 1, 1), cost(N - 1, 2))));
    }

    static int cost(int N, int color) {

        // 만약 탐색하지 않은 배열이라면
        if (DP[N][color] == 0) {

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            if (color == 0) {
                DP[N][0] = Math.min(cost(N - 1, 1), cost(N - 1, 2)) + Cost[N][0];
            } else if (color == 1) {
                DP[N][1] = Math.min(cost(N - 1, 0), cost(N - 1, 2)) + Cost[N][1];
            } else {
                DP[N][2] = Math.min(cost(N - 1, 0), cost(N - 1, 1)) + Cost[N][2];
            }

        }

        return DP[N][color];
    }
}
package Bkj_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            //끝나는 시간이 같은 경우에는 시작시간이 더 빠르도록 정렬
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int point = 0, count = 0;

        for (int i = 0; i < N; i++) {
            if (point <= arr[i][0]) {
                System.out.println(arr[i][0] + " " + arr[i][1]);
                point = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}

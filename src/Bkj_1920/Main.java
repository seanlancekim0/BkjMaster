package Bkj_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static String binarySearch(ArrayList<Integer> a, int input) {
        int min = 0, mid = 0, max = a.size() - 1;

        while(min <= max && max >= 0) {
            mid = (min + max) / 2;
            if (input < a.get(mid)) max = mid - 1;
            else if(input > a.get(mid)) min = mid + 1;
            else break;
        }
        return (a.get(mid) == input ? 1 : 0) + "\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));
        A.sort(Comparator.naturalOrder());

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) sb.append(binarySearch(A, Integer.parseInt(st.nextToken())));
        System.out.print(sb);
    }
}
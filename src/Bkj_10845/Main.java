package Bkj_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str;
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            switch (str) {
                case "push" -> {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
                case "pop" -> {
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.remove(0)).append("\n");
                }
                case "size" -> {
                    sb.append(queue.size()).append("\n");
                }
                case "empty" -> {
                    if (queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
                case "front" -> {
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.get(0)).append("\n");
                }
                case "back" -> {
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.get(queue.size() - 1)).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}

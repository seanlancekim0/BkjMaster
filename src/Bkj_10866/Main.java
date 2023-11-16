package Bkj_10866;

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
        ArrayList<Integer> deque =new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "push_front" -> {
                    deque.add(0, Integer.parseInt(st.nextToken()));
                }
                case "push_back" -> {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
                case "pop_front" -> {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.remove(0)).append("\n");
                }
                case "pop_back" -> {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.remove(deque.size() - 1)).append("\n");
                }
                case "size" -> {
                    sb.append(deque.size()).append("\n");
                }
                case "empty" -> {
                    if (deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
                case "front" -> {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.get(0)).append("\n");
                }
                case "back" -> {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.get(deque.size() - 1)).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}

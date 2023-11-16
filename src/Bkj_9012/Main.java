package Bkj_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack;

        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            String[] str = br.readLine().split("");

            for (String s : str) {
                if (s.equals(")")) {
                    if (stack.isEmpty() || stack.pop().equals(s)) {
                        stack.push("f");
                        break;
                    }
                } else stack.push(s);
            }
            if (stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }
}

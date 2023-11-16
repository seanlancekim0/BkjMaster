package Bkj_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        int in = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(in++);
        for (int i = 0; i < n; i++) {
            while (stack.peek() < arr.get(i)) {
                stack.push(in++);
                sb.append("+\n");
            }
            if (stack.peek() > arr.get(i)) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}

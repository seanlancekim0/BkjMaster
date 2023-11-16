package Bkj_10828;

import javax.sql.rowset.serial.SerialStruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Stack {

        private final ArrayList<Integer> arrayList = new ArrayList<> ();
        StringBuilder stringBuilder = new StringBuilder();

        private void push(String X) {
            arrayList.add(0, Integer.parseInt(X));
        }
        private void pop() {
            if (arrayList.isEmpty()) {
                stringBuilder.append(-1).append("\n");
                return;
            }
            stringBuilder.append(arrayList.remove(0)).append("\n");
        }
        private void size() {
            stringBuilder.append(arrayList.size()).append("\n");
        }
        private void empty() {
            stringBuilder.append(arrayList.isEmpty() ? 1 : 0).append("\n");
        }
        private void top() {

            if (arrayList.isEmpty()) {
                stringBuilder.append(-1).append("\n");
                return;
            }
            stringBuilder.append(arrayList.get(0)).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            switch (s) {
                case "pop" -> stack.pop();
                case "size" -> stack.size();
                case "empty" -> stack.empty();
                case "top" -> stack.top();
                default -> {
                    StringTokenizer stringTokenizer = new StringTokenizer(s);
                    stringTokenizer.nextToken();
                    stack.push(stringTokenizer.nextToken());
                }
            }
        }
        System.out.print(stack.stringBuilder);
    }
}

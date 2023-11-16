package Bkj_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Doc> queue;
        ArrayList<Integer> arr;

        int N, M;
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (K-- > 0) {
            queue = new LinkedList<>();
            arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Doc mDoc = new Doc(0);
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.add(temp);
                Doc tDoc = new Doc(temp);
                queue.add(tDoc);
                if (i == M) mDoc = tDoc;
            }
            arr.sort(Comparator.reverseOrder());
//            for (int i : arr) System.out.print(i+" ");

            Doc doc;
            int count = 0;
            while (!queue.isEmpty()) {
                doc = queue.poll();
                if (arr.get(count) == doc.priority) {
//                    System.out.println(arr.get(count) + " " + doc.priority);
                    if (mDoc.equals(doc)) {
//                        System.out.println(doc.priority + " " + doc);
//                        System.out.println(mDoc.priority + " " + mDoc + "\n");
                        sb.append(++count).append("\n");
                        break;
                    }
                    count++;
                } else {
                    queue.add(doc);
                }
            }
        }
        System.out.print(sb);
    }
}

class Doc {
    int priority;

    public Doc(int priority) {
        this.priority = priority;
    }
}

package Bkj_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    //최소힙 minHeap을 구현
    static ArrayList<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        minHeap = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int temp = 0;

        //입력에 대한 처리
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp != 0) insert(temp);
            else sb.append(pull()).append("\n");
        }

        System.out.print(sb);
    }

    static void insert(int input) {
        if (minHeap.isEmpty()) {
            minHeap.add(input);
            return;
        }

        //새로 추가한 입력값의 index
        int index = minHeap.size();
        //입력값과 비교할 부모 노드의 값
        int parent = minHeap.get((index - 1) / 2);
        minHeap.add(input);
        //input값이 그 부모노드보다 작으면 계속 위치를 바꿔준다.
        while(input < parent) {
            minHeap.set(index, parent);
            index = (index - 1) / 2;
            minHeap.set(index, input);
            parent = minHeap.get((index - 1) / 2);
        }
    }
    static int pull() {
        if (minHeap.isEmpty()) return 0;
        //크기가 2이하인 경우 바로 root노드를 빼서 return
        if (minHeap.size() < 3) return minHeap.remove(0);

        int result = minHeap.get(0), index = 0, minidx, temp;

        //minHeap의 가장 끝 노드값을 root로 옮기고 크기를 1 줄인다.
        minHeap.set(0, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);
        //크기가 3이었을 경우 왼쪽 자식노드만 비교
        if (minHeap.size() == 2 || minHeap.get(index * 2 + 1) < minHeap.get(index * 2 + 2)) minidx = index * 2 + 1;
        else minidx = index * 2 + 2;
        while (minHeap.get(index) > minHeap.get(minidx)) {
            temp = minHeap.get(index);
            minHeap.set(index, minHeap.get(minidx));
            minHeap.set(minidx, temp);
        }
        return result;
    }
}
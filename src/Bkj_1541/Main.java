package Bkj_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;

        String[] arr = str.split("-");
        //첫 "-"이전 까지의 숫자 더하기
        for (String s : arr[0].split("\\+"))
            result += Integer.parseInt(s);

        //첫 "-"이후 숫자 빼기
        for (int i =1;i<arr.length;i++)
            for (String s : arr[i].split("\\+"))
                result -= Integer.parseInt(s);

        System.out.println(result);
    }
}
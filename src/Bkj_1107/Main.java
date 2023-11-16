package Bkj_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()),
                M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        if (M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) set.add(Integer.parseInt(st.nextToken()));
        }

        String n = N + "", str = "";
        for (int i = 0; i < n.length(); i++) {
            for (int j = 0; j < 10; j++) {
                int temp = 9 - j;
                System.out.println(i+" "+"j:"+j+" " +(Integer.parseInt(str+"0")));
                if (i > 0 && i < n.length() - 1
                        && Integer.parseInt(n.substring(i - 1, i + 1)) - Integer.parseInt(str+"0") > 9){
                    if (!set.contains(temp)) continue;
                    System.out.println(temp);
                    str += temp;
                    System.out.println("str1: "+str);
                    break;
                }
                if (i > 0 && Integer.parseInt(n.substring(i - 1)) - Integer.parseInt(str+"0") > 9){
                    if (!set.contains(temp)) continue;
                    str += temp;
                    System.out.println("str2: "+str);
                    break;
                }
                temp = n.charAt(i) - '0' + j;
                if (!set.contains(temp) && temp < 10) {
                    System.out.println("3th: "+temp);
                    str += temp;
                    break;
                }
                temp -= 2 * j;
                if (!set.contains(temp) && temp >= 0) {
                    System.out.println("4th: "+temp);
                    str += temp;
                    break;
                }
            }
        }
        System.out.println("str::: "+str);
        int count = n.length() + Math.abs(N - Integer.parseInt(str));
        System.out.println(Math.min(count, Math.abs(N - 100)));
    }
}

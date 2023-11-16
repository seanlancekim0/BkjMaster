package Bkj_1654;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.StringTokenizer;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int K = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < K; i++) list.add(Integer.parseInt(reader.readLine()));
            list.sort(Comparator.reverseOrder());

            //이진탐색
            long min = 1, max = list.get(0), mid = 0;

            while (min <= max) {
                mid = (min + max) / 2;

                long count = 0;

                for(var val : list) {
                    count += val / mid;
                }

                //구해야하는 랜선개수 N보다 count가 적은 경우 랜선개수를 늘리기 위해 mid값을 줄여야 하므로 max값을 낮춘다.
                if (count < N) max = mid - 1;
                //N보다 count가 같거나 큰 경우 랜선개수를 줄이기 위해 mid값을 높여야 하므로 min값을 높인다.
                else min = mid + 1;

            }

            System.out.println((min + max) / 2);
        }
    }

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) {
                plus.add(book);
            } else {
                minus.add(-book);
            }
        }

        int pN = plus.size();
        int mN = minus.size();

        plus.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        minus.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        List<Integer> distance = new ArrayList<>();

        for (int i = 0; i < pN; i+= M) {
            distance.add(plus.get(i));
        }

        for (int i = 0; i < mN; i+= M) {
            distance.add(minus.get(i));
        }

        int result = 0;
        int max = 0;

        for (int dist : distance) {
            result += 2 * dist;
            max = Math.max(max, dist);
        }

        result -= max;

        System.out.println(result);
    }
}
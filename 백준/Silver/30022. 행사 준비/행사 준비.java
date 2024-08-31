import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Product implements Comparable<Product>{
        int diff;
        int[] values;

        public Product(int diff, int[] values) {
            this.diff = diff;
            this.values = values.clone();
        }

        @Override
        public int compareTo(Product other) {
            return this.diff - other.diff;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] C = new int[2];
        C[0] = Integer.parseInt(st.nextToken());
        C[1] = Integer.parseInt(st.nextToken());

        PriorityQueue<Product> pq = new PriorityQueue<>();


        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] values = new int[2];
            values[0] = Integer.parseInt(st.nextToken());
            values[1] = Integer.parseInt(st.nextToken());
            pq.add(new Product(values[0] - values[1], values));
        }

        int cnt = 0;
        long result = 0;
        while (!pq.isEmpty()) {
            Product x = pq.poll();

            if (cnt < C[0]) {
                result +=x.values[0];
            } else {
                result +=x.values[1];
            }
            cnt++;
        }

        System.out.println(result);

    }
}
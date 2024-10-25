import java.io.*;
import java.util.*;

public class Main {

    public static class Order implements Comparable<Order>{
        int n;
        int idx;
        int cnt;

        public Order (int n, int idx, int cnt) {
            this.n = n;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Order o) {
            if (this.cnt == o.cnt) {
                return this.idx - o.idx;
            }
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Order> que = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Map<Integer, Integer> M = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            if (M.containsKey(k)) {
                M.replace(k, M.get(k)+1);
            } else {
                M.put(k, 1);
            }
        }
        for (int i=0; i<N; i++) {
            if (M.containsKey(arr[i])) {
                que.offer(new Order(arr[i], i, M.get(arr[i])));
                M.remove(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            Order order = que.poll();
            for (int i=0; i<order.cnt; i++) {
                sb.append(order.n).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
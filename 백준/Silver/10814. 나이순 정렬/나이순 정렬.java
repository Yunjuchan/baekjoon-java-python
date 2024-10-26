import java.io.*;
import java.util.*;

public class Main {

    public static class Order implements Comparable<Order>{
        int age;
        int idx;
        String name;

        public Order (int age, int idx, String name) {
            this.age = age;
            this.idx = idx;
            this.name = name;
        }

        @Override
        public int compareTo(Order o) {
            if (this.age == o.age) {
                return this.idx - o.idx;
            }
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Order> que = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            que.offer(new Order(age, i, name));
        }

        while (!que.isEmpty()) {
            Order order = que.poll();
            System.out.println(order.age + " " + order.name);
        }

    }
}
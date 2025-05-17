import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int p;
        int q;

        public Node(int p, int q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public int compareTo(Node other) {
            return this.p - other.p;
        }
    }

    public static class Computer implements Comparable<Computer> {
        int idx;
        int t;

        public Computer(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }

        @Override
        public int compareTo(Computer other) {
            if (this.t == other.t) {
                return this.idx - other.idx;
            }
            return this.t - other.t;
        }
    }

    public static class Computer2 implements Comparable<Computer2> {
        int idx;
        int t;

        public Computer2(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }

        @Override
        public int compareTo(Computer2 other) {
            return this.idx - other.idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int size = 1;

        int[] cnt = new int[N + 1];
        PriorityQueue<Node> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            que.offer(new Node(p, q));
        }

        PriorityQueue<Computer> que2 = new PriorityQueue<>();
        PriorityQueue<Computer2> resQue = new PriorityQueue<>();
        que2.offer(new Computer(1, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();

            while (!que2.isEmpty() && que2.peek().t <= cur.p) {
                Computer computer = que2.poll();
                resQue.offer(new Computer2(computer.idx, computer.t));
            }

            if (!resQue.isEmpty()) {
                Computer2 computer = resQue.poll();
                que2.offer(new Computer(computer.idx, cur.q));
                cnt[computer.idx]++;
            } else {
                int idx = ++size;
                que2.offer(new Computer(idx, cur.q));
                cnt[idx] = 1;
            }
        }

        sb.append(size).append("\n");
        for (int i = 1; i <= size; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb);
    }
}
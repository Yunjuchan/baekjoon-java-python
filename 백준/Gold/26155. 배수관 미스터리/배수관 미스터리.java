import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int cnt;

    public static class Pipe implements Comparable<Pipe> {
        int a;
        int b;
        double p;

        public Pipe(int a, int b, double p) {
            this.a =a;
            this.b =b;
            this.p =p;
        }

        @Override
        public int compareTo(Pipe other) {
            if (this.p == other.p) {
                return other.a - this.a;
            }
            return Double.compare(other.p, this.p);
        }
    }

    public static int find(int x) {
        if (parent[x] == 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        parent[pb] = pa;
        cnt--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cnt = N;
        parent = new int[N+1];

        Queue<Pipe> que = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double p = Double.parseDouble(st.nextToken());

            que.offer(new Pipe(a, b, p));
        }

        int Q = Integer.parseInt(br.readLine());
        int[] query = new int[Q];
        for (int i = 0; i < Q; i++) {
            double p = Double.parseDouble(br.readLine());
            que.offer(new Pipe(0, i, p));
        }

        while (!que.isEmpty()) {
            Pipe p = que.poll();
            if (p.a == 0) {
                query[p.b] = cnt;
            } else {
                union(p.a, p.b);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(query[i]).append("\n");
        }
        System.out.println(sb);
    }
}
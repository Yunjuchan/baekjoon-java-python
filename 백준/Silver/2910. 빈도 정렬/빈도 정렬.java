import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int n;
        int cnt;
        int init;

        public Node(int n, int cnt, int init) {
            this.n = n;
            this.cnt = cnt;
            this.init = init;
        }

        public int compareTo(Node other) {
            if (this.cnt == other.cnt) {
                return this.init - other.init;
            }
            return other.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer, int[]> map = new HashMap<>();

        PriorityQueue<Node> que = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.putIfAbsent(n, new int[] {0, i});
            map.get(n)[0]++;
        }


        for (int n : map.keySet()) {
            int[] value = map.get(n);
            int cnt = value[0];
            int init = value[1];
            que.offer(new Node(n, cnt, init));
//            System.out.println(key + " " + value[0] + " " + value[1]);
        }

        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (int i = 0; i < cur.cnt; i++) {
                sb.append(cur.n).append(" ");
            }
        }

        System.out.println(sb);
    }
}
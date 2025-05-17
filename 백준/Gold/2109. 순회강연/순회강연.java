import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int p;
        int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            if (this.d == other.d) {
                return other.p - this.p;
            }
            return this.d - other.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> que = new PriorityQueue<>();

        /**
         * Node는 d가 작고 p가 큰 순으로 que에 저장
         * 만약 강의que의 사이즈가 이번 Node의 d보다 작다면 그냥삽입
         * 만약 강의 que의 사이즈가 이번 Node의 d와 같다면 p가 가장 작은 것을 제거
         */

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            que.offer(new Node(p, d));
        }

        PriorityQueue<Integer> que2 = new PriorityQueue<>();

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (que2.size() < cur.d) {
                que2.offer(cur.p);
            } else {
                if (que2.peek() < cur.p) {
                    que2.poll();
                    que2.offer(cur.p);
                }
            }
        }
        int result = 0;

        while (!que2.isEmpty()) {
            result += que2.poll();
        }

        System.out.println(result);
    }
}
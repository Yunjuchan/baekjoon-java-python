import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        Deque<Integer> que;

        public Node() {
            this.que = new ArrayDeque<>();
        }

        public void pushFront(int x) {
            que.offerFirst(x);
        }

        public void pushBack(int x) {
            que.offerLast(x);
        }

        public int popFront() {
            if (que.isEmpty()) {
                return -1;
            }
            return que.pollFirst();
        }

        public int popBack() {
            if (que.isEmpty()) {
                return -1;
            }
            return que.pollLast();
        }

        public int size() {
            return que.size();
        }

        public int empty() {
            if (que.isEmpty()) {
                return 1;
            }
            return 0;
        }

        public int front() {
            if (que.isEmpty()) {
                return -1;
            }
            return que.peekFirst();
        }

        public int back() {
            if (que.isEmpty()) {
                return -1;
            }
            return que.peekLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Node node = new Node();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int x;
            if (query.equals("push_front")) {
                x = Integer.parseInt(st.nextToken());
                node.pushFront(x);
            } else if (query.equals("push_back")) {
                x = Integer.parseInt(st.nextToken());
                node.pushBack(x);
            } else if (query.equals("pop_front")) {
                sb.append(node.popFront()).append("\n");
            } else if (query.equals("pop_back")) {
                sb.append(node.popBack()).append("\n");
            } else if (query.equals("size")) {
                sb.append(node.size()).append("\n");
            } else if (query.equals("empty")) {
                sb.append(node.empty()).append("\n");
            } else if (query.equals("front")) {
                sb.append(node.front()).append("\n");
            } else if (query.equals("back")) {
                sb.append(node.back()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
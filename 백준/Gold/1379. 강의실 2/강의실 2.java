import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int n;
        int s;
        int e;

        public Node(int n, int s, int e) {
            this.n = n;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node other) {
            return this.s - other.s;
        }
    }

    public static class Room implements Comparable<Room> {
        int idx;
        int t;

        public Room(int idx, int t) {
            this.idx = idx;
            this.t = t;
        }

        @Override
        public int compareTo(Room other) {
            return this.t - other.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] classIdx = new int[N + 1];
        PriorityQueue<Node> que = new PriorityQueue<>();
        PriorityQueue<Room> rooms = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            que.offer(new Node(n, s, e));
        }

        rooms.offer(new Room(1, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (rooms.peek().t <= cur.s) {
                Room room = rooms.poll();
                room.t = cur.e;
                classIdx[cur.n] = room.idx;
                rooms.offer(room);
            } else {
                int idx = rooms.size() + 1;
                rooms.add(new Room(idx, cur.e));
                classIdx[cur.n] = idx;
            }
        }

        sb.append(rooms.size()).append("\n");
        for (int i = 1; i <= N; i++) {
            sb.append(classIdx[i]).append("\n");
        }

        System.out.println(sb);
    }
}
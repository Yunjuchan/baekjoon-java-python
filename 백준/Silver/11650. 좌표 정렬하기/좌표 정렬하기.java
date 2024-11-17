import java.io.*;
import java.util.*;

public class Main {

    public static class Position implements Comparable<Position> {
        int x;
        int y;

        public Position (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo (Position o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Queue<Position> que = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            que.add(new Position(x, y));
        }

        while (!que.isEmpty()) {
            Position p = que.poll();
            System.out.println(p.toString());
        }
    }
}
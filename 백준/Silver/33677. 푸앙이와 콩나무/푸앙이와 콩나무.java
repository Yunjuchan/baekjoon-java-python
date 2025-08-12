import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int h;
        int t;
        int w;

        public Node(int h, int t, int w) {
            this.h = h;
            this.t = t;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] visited = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        Queue<Node> que = new LinkedList<>();


        que.offer(new Node(0, 0, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.h + 1 > N || visited[cur.h + 1][0] < cur.t + 1 || (visited[cur.h + 1][0] == cur.t + 1 && visited[cur.h + 1][1] < cur.w + 1)) {
            } else {
                visited[cur.h + 1][0] = cur.t + 1;
                visited[cur.h + 1][1] = cur.w + 1;
                que.offer(new Node(cur.h + 1, cur.t + 1, cur.w + 1));
            }

            if (cur.h * 3 > N || visited[cur.h * 3][0] < cur.t + 1 || (visited[cur.h * 3][0] == cur.t + 1 && visited[cur.h * 3][1] < cur.w + 3)) {
            } else {
                visited[cur.h * 3][0] = cur.t + 1;
                visited[cur.h * 3][1] = cur.w + 3;
                que.offer(new Node(cur.h * 3, cur.t + 1, cur.w + 3));
            }

            if (cur.h > (int) Math.sqrt(Integer.MAX_VALUE) || cur.h * cur.h > N || visited[cur.h * cur.h][0] < cur.t + 1 || (visited[cur.h * cur.h][0] == cur.t + 1 && visited[cur.h * cur.h][1] < cur.w + 5)) {
            } else {
                visited[cur.h * cur.h][0] = cur.t + 1;
                visited[cur.h * cur.h][1] = cur.w + 5;
                que.offer(new Node(cur.h * cur.h, cur.t + 1, cur.w + 5));
            }
        }

        System.out.println(visited[N][0] + " " + visited[N][1]);
    }
}
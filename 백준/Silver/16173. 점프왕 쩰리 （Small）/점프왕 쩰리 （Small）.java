import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, 1, 0, -1};

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Node> que = new LinkedList<>();

        que.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            if (y == N - 1 && x == N - 1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d] * arr[y][x];
                int nx = x + dx[d] * arr[y][x];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                que.offer(new Node(ny, nx));
            }
        }

        System.out.println("Hing");
    }
}
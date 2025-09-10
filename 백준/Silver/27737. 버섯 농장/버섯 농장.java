import java.io.*;
import java.util.*;

public class Main {

    static class Node {

        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, K;
    static int[] dy, dx;
    static int[][] arr;

    static int bfs(int y, int x) {
        int cnt = 1;

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(y, x));
        arr[y][x] = 1;
        while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || arr[ny][nx] == 1) {
                    continue;
                }

                que.offer(new Node(ny, nx));
                arr[ny][nx] = 1;
                cnt++;
            }
        }

        int result = (cnt + K - 1) / K;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dy = new int[] {1, 0, -1, 0};
        dx = new int[] {0, -1, 0, 1};

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int used = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    continue;
                }
                used += bfs(i, j);
            }
        }

        if (used == 0 || used > M) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M - used);
        }
    }
}
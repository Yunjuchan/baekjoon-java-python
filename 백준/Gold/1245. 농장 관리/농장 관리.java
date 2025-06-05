import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dy = new int[] {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dx = new int[] {0, 1, 0, -1, 1, -1, 1, -1};
    static boolean[][] visited;
    static int[][] arr;

    public static boolean bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {y, x});

        boolean[][] curVisited = new boolean[N][M];
        curVisited[y][x] = true;
        visited[y][x] = true;

        boolean isTop = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            y = cur[0];
            x = cur[1];

            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }
                if (arr[ny][nx] < arr[y][x]) {
                    visited[ny][nx] = true;
                } else if (arr[ny][nx] == arr[y][x]) {
                    if (!curVisited[ny][nx]) {
                        curVisited[ny][nx] = true;
                        que.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                } else {
                    isTop = false;
                }
            }
        }
        return isTop;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (bfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
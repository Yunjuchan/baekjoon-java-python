import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                arr[y][x] = line.charAt(x) - '0';
            }
        }

        Queue<int[]> que = new LinkedList<>();
        for (int x = 0; x < M; x++) {
            if (arr[0][x] == 0) {
                arr[0][x] = 1;
                que.offer(new int[] {0, x});
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 1) {
                    continue;
                }
                arr[ny][nx] = 1;
                if (ny == N - 1) {
                    System.out.println("YES");
                    return;
                }
                que.offer(new int[] {ny, nx});
            }
        }

        System.out.println("NO");
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[] directY = {1,0,-1,0};
    static int[] directX = {0,1,0,-1};

    static int N, M;
    static int[][] A, B;
    static boolean[][] visited;

    public static Queue<int[]> bfs(Queue<int[]> que) {
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i=0; i<4; i++) {
                int ny = now[0] + directY[i];
                int nx = now[1] + directX[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx]) {
                    continue;
                }
                if (A[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    que.add(new int[]{ny, nx});
                } else {
                    B[ny][nx]++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (B[i][j] >= 2 && !visited[i][j]) {
                    que.add(new int[]{i, j});
                    A[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        return que;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        visited[0][0] = true;

        int t = 0;
        que = bfs(que);
        while (!que.isEmpty()) {
            que = bfs(que);
            t++;
        }
        System.out.println(t);
    }
}
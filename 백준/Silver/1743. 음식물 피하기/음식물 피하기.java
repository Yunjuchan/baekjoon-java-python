import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dy = new int[]{1,0,-1,0};
    static int [] dx = new int[]{0,1,0,-1};
    static int[][] arr;

    public static int bfs(int i, int j) {

        int cnt = 0;

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{i, j});
        arr[i][j] = 0;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            cnt++;

            for (int k = 0; k < 4; k++) {
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 0) {
                    continue;
                }
                arr[ny][nx] = 0;
                que.offer(new int[]{ny, nx});
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        arr = new int[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            arr[r][c] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        System.out.println(result);
    }
}

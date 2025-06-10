import java.io.*;
import java.util.*;

public class Main {

    static int N, M, vCnt, minTime = Integer.MAX_VALUE;
    static int[] dy, dx;
    static int[][] lab;
    static List<int[]> virusList;
    public static void dfs(int depth, int start, int[][] initVirus) {
        if (depth == M) {
            int time = spread(initVirus);
            minTime = Math.min(minTime, time);
            return;
        }
        if (start == vCnt) {
            return;
        }

        dfs(depth, start + 1, initVirus);
        initVirus[depth] = virusList.get(start);
        dfs(depth + 1, start + 1, initVirus);
        initVirus[depth] = null;
    }
    public static int spread(int[][] initVirus) {
        int[][] status = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 1) {
                    status[i][j] = -1;
                    visited[i][j] = true;
                }
            }
        }

        Queue<int[]> que = new LinkedList<>();
        for (int[] virus : initVirus) {
            int y = virus[0];
            int x = virus[1];
            que.offer(new int[] {0, y, x});
            visited[y][x] = true;
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int y = cur[1];
            int x = cur[2];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) {
                    continue;
                }
                status[ny][nx] = cur[0] + 1;
                visited[ny][nx] = true;
                que.offer(new int[] {cur[0] + 1, ny, nx});
            }
        }

        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
                time = Math.max(time, status[i][j]);
            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dy = new int[] {1, 0, -1, 0};
        dx = new int[] {0, 1, 0, -1};

        lab = new int[N][N];
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virusList.add(new int[] {i, j});
                }
            }
        }
        vCnt = virusList.size();

        dfs(0, 0, new int[M][2]);
        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }
}


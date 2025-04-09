import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dy = new int[] {1,0,-1,0};
    static int[] dx = new int[] {0,-1,0,1};
    static boolean[][] checked;
    static int[][] map;
    static int[][] adj;

    public static void checkIsland(int idx, int y, int x) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] {y, x});
        map[y][x] = idx;
        checked[y][x] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || checked[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }
                checked[ny][nx] = true;
                map[ny][nx] = idx;
                que.offer(new int[] {ny, nx});
            }
        }
    }

    public static void makeBridge(int y, int x) {
        int s = map[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            int cnt = 0;
            while (true) {
                ny += dy[i];
                nx += dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == s) {
                    break;
                }
                if (map[ny][nx] != 0) {
                    if (cnt <= 1) {
                        break;
                    }
                    adj[s][map[ny][nx]] = Math.min(adj[s][map[ny][nx]], cnt);
                    adj[map[ny][nx]][s] = Math.min(adj[map[ny][nx]][s], cnt);
                    break;
                }
                cnt += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checked[i][j] && map[i][j] != 0) {
                    checkIsland(idx, i, j);
                    idx++;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        adj = new int[idx][idx];

        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    makeBridge(i, j);
                }
            }
        }

        int dist = Integer.MAX_VALUE;
        int s1 = 0;
        int s2 = 0;
        boolean[] visited = new boolean[idx];
        for (int i = 0; i < idx; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (dist > adj[i][j]) {
                    dist = adj[i][j];
                    s1 = i;
                    s2 = j;
                }
            }
        }
        visited[s1] = visited[s2] = true;

        PriorityQueue<int[]> que = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }
        );

        for (int i = 1; i < idx; i++) {
            if (adj[s1][i] != Integer.MAX_VALUE && !visited[i]) {
                que.offer(new int[] {adj[s1][i], s1, i});
            }

            if (adj[s2][i] != Integer.MAX_VALUE && !visited[i]) {
                que.offer(new int[] {adj[s2][i], s2, i});
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (visited[cur[2]]) {
                continue;
            }

            visited[cur[2]] = true;
            dist += cur[0];

            for (int i = 1; i < idx; i++) {
                if (adj[cur[2]][i] != Integer.MAX_VALUE && !visited[i]) {
                    que.offer(new int[] {adj[cur[2]][i], cur[2], i});
                }
            }
        }

        for (int i = 1; i < idx; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(dist);
    }
}
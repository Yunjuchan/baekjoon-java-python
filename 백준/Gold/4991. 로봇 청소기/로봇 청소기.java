import java.io.*;
import java.util.*;

public class Main {
    static int H, W, dustN, result;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static char[][] arr;
    static int[][] adj, dustList;
    static boolean[] visited;

    public static class Status {
        int cnt;
        int y;
        int x;

        public Status (int cnt, int y, int x) {
            this.cnt = cnt;
            this.y = y;
            this.x = x;
        }
    }

    public static void fillAdj () {

        for (int i = 0; i <= dustN; i++) {
            char[][] arrClone = new char[H][W];
            for (int j = 0; j < H; j++) {
                arrClone[j] = arr[j].clone();
            }

            arrClone[dustList[0][0]][dustList[0][1]] = '.';
            arrClone[dustList[i][0]][dustList[i][1]] = 'o';
            Queue<Status> que = new LinkedList<>();
            que.offer(new Status(0, dustList[i][0], dustList[i][1]));


            while (!que.isEmpty()) {
                Status status = que.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = status.y + dy[j];
                    int nx = status.x + dx[j];
                    if (ny < 0 || nx < 0 || ny >= H || nx >= W || arrClone[ny][nx] == 'o' || arrClone[ny][nx] == 'x') {
                        continue;
                    }

                    if (arrClone[ny][nx] == '*') {
                        for (int k = i + 1; k <= dustN; k++) {
                            if (dustList[k][0] == ny && dustList[k][1] == nx) {
                                adj[i][k] = status.cnt + 1;
                                adj[k][i] = status.cnt + 1;
                            }
                        }
                    }

                    que.offer(new Status(status.cnt + 1, ny, nx));
                    arrClone[ny][nx] = 'o';
                }
            }
        }
    }

    public static void dfs(int level, int prev, int sum) {
        if (level == dustN) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 1; i <= dustN; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(level + 1, i, sum + adj[prev][i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            boolean cantClean = false;
            arr = new char[H][W];

            if (W == 0 && H == 0) {
                return;
            }

            int[] robot = new int[2];
            List<int[]> dust = new ArrayList<>();
            dustN = 0;

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = line.charAt(j);

                    if (arr[i][j] == 'o') {
                        robot[0] = i;
                        robot[1] = j;
                    } else if (arr[i][j] == '*') {
                        dust.add(new int[]{i, j});
                        dustN++;
                    }
                }
            }

            visited = new boolean[dustN + 1];
            dustList = new int[dustN + 1][2];
            dustList[0][0] = robot[0];
            dustList[0][1] = robot[1];

            for (int i = 1; i <= dustN; i++) {
                dustList[i] = dust.get(i - 1).clone();
            }

            adj = new int[dustN + 1][dustN + 1];

            for (int i = 0; i <= dustN; i++) {
                Arrays.fill(adj[i], Integer.MAX_VALUE);
            }

            fillAdj();

            for (int i = 1; i <= dustN; i++) {
                if (adj[0][i] == Integer.MAX_VALUE) {
                    cantClean = true;
                    System.out.println(-1);
                    break;
                }
            }

            if (cantClean) {
                continue;
            }

            dfs(0, 0, 0);
            System.out.println(result);
        }
    }
}
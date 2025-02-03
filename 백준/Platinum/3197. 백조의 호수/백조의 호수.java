import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] lake;
    static boolean[][] visited;
    static int[] directY = {-1,1,0,0};
    static int[] directX = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        int[] swan1 = null;
        int[] swan2 = null;

        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> nextWaterQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] == 'L') {
                    waterQueue.add(new int[]{i, j});
                    if (swan1 == null) {
                        swan1 = new int[]{i, j};
                    } else {
                        swan2 = new int[]{i, j};
                    }
                } else if (lake[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        Queue<int[]> swanQueue = new LinkedList<>();

        Queue<int[]> nextSwanQueue = new LinkedList<>();
        visited = new boolean[R][C];

        swanQueue.add(swan1);
        visited[swan1[0]][swan1[1]] = true;

        int days = 0;
        boolean found = false;

        while (!found) {
            while (!swanQueue.isEmpty() && !found) {
                int[] cur = swanQueue.poll();
                int y = cur[0], x = cur[1];
                for (int d = 0; d < 4; d++) {
                    int ny = y + directY[d];
                    int nx = x + directX[d];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (visited[ny][nx]) {
                        continue;
                    }
                    visited[ny][nx] = true;

                    if (lake[ny][nx] == 'X') {
                        nextSwanQueue.add(new int[]{ny, nx});
                    } else {
                        swanQueue.add(new int[]{ny, nx});
                        if (lake[ny][nx] == 'L') {
                            found = true;
                            break;
                        }
                    }
                }
            }

            if (found) {
                break;
            }

            int waterSize = waterQueue.size();
            while (waterSize-- > 0) {
                int[] now = waterQueue.poll();
                int y = now[0], x = now[1];
                for (int d = 0; d < 4; d++) {
                    int ny = y + directY[d];
                    int nx = x + directX[d];
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }
                    if (lake[ny][nx] == 'X') {
                        lake[ny][nx] = '.';
                        nextWaterQueue.add(new int[]{ny, nx});
                    }
                }
            }
            waterQueue = nextWaterQueue;
            nextWaterQueue = new LinkedList<>();

            swanQueue = nextSwanQueue;
            nextSwanQueue = new LinkedList<>();

            days++;
        }
        System.out.println(days);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dy, dx;
    static int[][] arr;
    static int[][][] wind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = 0;

        dy = new int[] {0,1,0,-1};
        dx = new int[] {-1,0,1,0};
        wind = new int[][][] {
                {{-1, 0, 1}, {1, 0, 1}, {-1, -1, 7}, {1, -1, 7}, {-2, -1, 2}, {2, -1, 2}, {-1, -2, 10}, {1, -2, 10}, {0, -3, 5}},
                {{0, -1, 1}, {0, 1, 1}, {1, -1, 7}, {1, 1, 7}, {1, -2, 2}, {1, 2, 2}, {2, -1, 10}, {2, 1, 10}, {3, 0, 5}},
                {{-1, 0, 1}, {1, 0, 1}, {-1, 1, 7}, {1, 1, 7}, {-2, 1, 2}, {2, 1, 2}, {-1, 2, 10}, {1, 2, 10}, {0, 3, 5}},
                {{0, -1, 1}, {0, 1, 1}, {-1, -1, 7}, {-1, 1, 7}, {-1, -2, 2}, {-1, 2, 2}, {-2, -1, 10}, {-2, 1, 10}, {-3, 0, 5}}
        };

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int y = N / 2;
        int x = N / 2;
        int d = 0;
        int k = 1;
        int dCount = 1;
        while (!(y == 0 && x == 0)) {

            int ny = y + dy[d];
            int nx = x + dx[d];
            int initSand = arr[ny][nx];
            for (int i = 0; i < 9; i++) {
                int sy = y + wind[d][i][0];
                int sx = x + wind[d][i][1];
                int moveSand = initSand * wind[d][i][2] / 100;
                arr[ny][nx] -= moveSand;
                if (sy < 0 || sx < 0 || sy >= N || sx >= N) {
                    total += moveSand;
                } else {
                    arr[sy][sx] += moveSand;
                }
            }
            y = ny;
            x = nx;
            ny += dy[d];
            nx += dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                total += arr[y][x];
            } else {
                arr[ny][nx] += arr[y][x];
            }

            arr[y][x] = 0;

            if (--dCount == 0) {
                d = (d + 1) % 4;
                dCount = k;
                if (d % 2 == 1) {
                    k++;
                }
            }
        }
        System.out.println(total);
    }
}
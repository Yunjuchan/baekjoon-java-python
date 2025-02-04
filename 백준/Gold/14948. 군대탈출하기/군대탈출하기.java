import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][][] maxValue;
    static int[] directY = {1,0,-1,0};
    static int[] directX = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        maxValue = new int[2][N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 2; k++) {
                    maxValue[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }

        maxValue[0][0][0] = maxValue[1][0][0] = arr[0][0];

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,0});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int useEquip = now[0];
            int y = now[1];
            int x = now[2];

            for (int j = useEquip; j < 2; j++) {
                for (int i = 0; i < 4; i++) {
                    int ny = y + directY[i] * (j + 1 - useEquip);
                    int nx = x + directX[i] * (j + 1 - useEquip);
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                        continue;
                    }

                    int tmp = Math.max(maxValue[useEquip][y][x], arr[ny][nx]);
                    if (maxValue[j][ny][nx] <= tmp) {
                        continue;
                    }

                    maxValue[j][ny][nx] = tmp;
                    que.offer(new int[]{j, ny, nx});
                }
            }
        }

//        for (int i = 0; i < 2; i++) {
//            System.out.println(i + "번 째 max value 표");
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(maxValue[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }

        System.out.println(Math.min(maxValue[0][N-1][M-1], maxValue[1][N-1][M-1]));
    }
}
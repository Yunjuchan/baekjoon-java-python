import java.io.*;
import java.util.*;

public class Main {

    public static int[] directY = {1,0,-1,0};
    public static int[] directX = {0,1,0,-1};

    public static class Grid {
        int y;
        int x;
        int d;

        public Grid(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N][M];
        Queue<Grid> que = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 2) {
                    dist[i][j] = 0;
                    que.add(new Grid(i, j, 0));
                } else if (x == 1) {
                    dist[i][j] = -1;
                }
            }
        }

        while (!que.isEmpty()) {
            Grid grid = que.poll();
            for (int i=0; i<4; i++) {
                int dy = grid.y + directY[i];
                int dx = grid.x + directX[i];
                if (dy < 0 || dx < 0 || dy >= N || dx >= M || dist[dy][dx] != -1) {
                    continue;
                }
                dist[dy][dx] = grid.d+1;
                que.add(new Grid(dy, dx, dist[dy][dx]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
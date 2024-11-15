import java.io.*;
import java.util.*;

public class Main {
    public static class Position implements Comparable<Position>{
        int y;
        int x;
        int dist;

        public Position (int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo (Position o) {
            return (this.y + this.x) - (o.y + o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N][N];
        boolean[][] visited = new boolean[N][N];
        dp[0][0] = 1;
        int[][] A = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] directY = {1,0};
        int[] directX = {0,1};
        PriorityQueue<Position> que = new PriorityQueue<>();
        que.offer(new Position(0, 0, A[0][0]));
        while (!que.isEmpty()) {
            Position now = que.poll();
            if (now.y == N-1 && now.x == N-1) {
                break;
            } else if (now.dist == 0) {
                continue;
            }
            for (int i=0; i<2; i++) {
                int nY = now.y + directY[i] * now.dist;
                int nX = now.x + directX[i] * now.dist;
                if (nY >= N || nX >= N) {
                    continue;
                }
                dp[nY][nX] += dp[now.y][now.x];
                if (!visited[nY][nX] && A[nY][nX] != 0) {
                    que.offer(new Position(nY, nX, A[nY][nX]));
                    visited[nY][nX] = true;
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static int[] directY = {1, 1, 2, 2, -1, -1, -2, -2};
    public static int[] directX = {2, -2, 1, -1, 2, -2, 1, -1};
    public static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[][] dist = new int[r+1][c+1];
        int[][] ways = new int[r+1][c+1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        dist[1][1] = 0;
        ways[1][1] = 1;
        queue.add(new int[]{1, 1});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];

            for (int d = 0; d < 8; d++) {
                int ny = y + directY[d];
                int nx = x + directX[d];

                if (ny >= 1 && ny <= r && nx >= 1 && nx <= c) {
                    if (dist[ny][nx] > dist[y][x] + 1) {
                        dist[ny][nx] = dist[y][x] + 1;
                        ways[ny][nx] = ways[y][x];
                        queue.add(new int[]{ny, nx});
                    }
                    else if (dist[ny][nx] == dist[y][x] + 1) {
                        ways[ny][nx] = (ways[ny][nx] + ways[y][x]) % MOD;
                    }
                }
            }
        }

        if (dist[r][c] == Integer.MAX_VALUE) {
            System.out.println("None");
        } else {
            System.out.println(dist[r][c] + " " + ways[r][c]);
        }
    }
}
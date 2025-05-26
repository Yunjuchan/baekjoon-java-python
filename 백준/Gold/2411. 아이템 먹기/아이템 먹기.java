import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        int[][] items = new int[A + 2][2];
        int[] dy = new int[] {0, 1};
        int[] dx = new int[] {1, 0};
        items[A + 1][0] = N;
        items[A + 1][1] = M;

        dp[1][1] = 1;

        for (int i = 1; i <= A; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            dp[y][x] = -1;
        }

        for (int i = 1; i <= A + 1; i++) {
            for (int y = items[i - 1][0]; y <= items[i][0]; y++) {
                for (int x = items[i - 1][1]; x <= items[i][1]; x++) {
                    if ((y == items[i][0] && x == items[i][1]) || dp[y][x] == -1) {
                        continue;
                    }
                    for (int d = 0; d < 2; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny > N || nx > M || dp[ny][nx] == -1) {
                            continue;
                        }
                        dp[ny][nx] += dp[y][x];
                    }
                }
            }
        }
        System.out.println(dp[N][M]);

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
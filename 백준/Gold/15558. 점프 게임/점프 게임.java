import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dy = new int[] {0, 0, 1};
        int[] dx = new int[] {1, -1, K};

        boolean[][] arr = new boolean[2][N];

        for (int i = 0; i < 2; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) - '0' == 1) {
                    arr[i][j] = true;
                }
            }
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0, 0});
        arr[0][0] = true;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int y = now[0];
            int x = now[1];
            int t = now[2];
//            System.out.println(y + " " + x + " " + t);

            for (int i = 0; i < 3; i++) {
                int ny = (y + dy[i]) % 2;
                int nx = x + dx[i];

                if (nx <= t) {
                    continue;
                }

                if (nx >= N) {
                    System.out.println(1);
                    return;
                }

                if (!arr[ny][nx]) {
                    continue;
                }

                arr[ny][nx] = false;
                que.offer(new int[] {ny, nx, now[2] + 1});
            }
        }
        System.out.println(0);
    }
}
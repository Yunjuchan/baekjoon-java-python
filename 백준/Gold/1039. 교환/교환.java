import java.io.*;
import java.util.*;

public class Main {

    public static int pick(int N, int idx) {
        return N % (int) Math.pow(10, idx + 1) / (int) Math.pow(10, idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = -1;
        boolean[][] visited = new boolean[11][1_000_001];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int M = 1;
        while ((int) Math.pow(10, M) <= N) {
            M++;
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {N, 0});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
//            System.out.println(cur[0] + " " + cur[1]);
            if (cur[1] == K) {
                result = Math.max(result, cur[0]);
                continue;
            }
            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    if (j == M - 1 && pick(cur[0], i) == 0) {
                        continue;
                    }
                    int t = (pick(cur[0], j) - pick(cur[0], i));
                    int n = cur[0] + t * (int) Math.pow(10, i) - t * (int) Math.pow(10, j);
                    if (visited[cur[1] + 1][n]) {
                        continue;
                    }
                    visited[cur[1] + 1][n] = true;
                    que.offer(new int[] {n, cur[1] + 1});
                }
            }
        }

        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static final int INIT = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] floyd = new int[N + 1][N + 1];
        int[][] next = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(floyd[i], INIT);
            for (int j = 1; j <= N; j++) {
                next[i][j] = j;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            floyd[a][b] = Math.min(floyd[a][b], c);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if (j == k || j == i) {
                        continue;
                    }
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int value = 0;
                if (floyd[i][j] != INIT) {
                    value = floyd[i][j];
                }
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 1;
                StringBuilder path = new StringBuilder(String.valueOf(i));
                if (floyd[i][j] == INIT) {
                    sb.append(0).append("\n");
                    continue;
                }
                int now = i;
                while (next[now][j] != j) {
                    now = next[now][j];
                    path.append(" ").append(now);
                    cnt++;
                }
                cnt++;
                path.append(" ").append(j);
                sb.append(cnt).append(" ").append(path).append("\n");
            }
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, result = Integer.MIN_VALUE;
    static int[][] arr;

    static int calc(int[] order) {
        int prev = 0, flavor = 0;
        for (int i = 0; i < N; i++) {
            if (arr[2][prev] * arr[2][order[i]] > K) return -1;
            flavor += arr[0][prev] * arr[1][order[i]];
            prev = order[i];
        }
        return flavor;
    }

    public static void dfs(int level, int bitmask, int[] order) {
        if (level == N) {
            result = Math.max(result, calc(order));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((bitmask & (1 << i)) != 0) continue;
            order[level] = i;
            dfs(level + 1, bitmask | (1 << i), order);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[3][N + 1];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, new int[N]);
        System.out.println(result);
    }
}
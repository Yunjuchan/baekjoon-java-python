import java.io.*;
import java.util.*;

public class Main {

    static int[] depths;
    static int[][] parents;
    static List<List<Integer>> adj;

    public static void checkDepth(int level, int now) {
        for (int next : adj.get(now)) {
            if (depths[next] != 0) {
                continue;
            }
            depths[next] = level + 1;
            parents[0][next] = now;
            checkDepth(level + 1, next);
        }
    }

    public static int downDepth(int x, int goal) {
        int i = 0;
        int diff = depths[x] - goal;
        while (diff != 0) {
            if (diff % 2 == 1) {
                x = parents[i][x];
            }
            diff /= 2;
            i++;
        }

        return x;
    }

    public static int LCA(int A, int B) {
        int minDepth = Math.min(depths[A], depths[B]);

        A = downDepth(A, minDepth);
        B = downDepth(B, minDepth);

        for (int i = 19; i >= 0; i--) {
            if (A == B) {
                return A;
            }

            if (parents[i][A] != parents[i][B]) {
                A = parents[i][A];
                B = parents[i][B];
            }
        }
        return parents[0][A];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        depths = new int[N + 1];
        parents = new int[20][N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        depths[1] = 1;
        checkDepth(1, 1);

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j <= N; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(LCA(A, B)).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parent, depth;
    static List<List<Integer>> children;

    static void checkDepth(int level, int now) {
        for (int child : children.get(now)) {
            depth[child] = level + 1;
            checkDepth(level + 1, child);
        }
    }

    static int LCA(int A, int B) {
        int minDepth = Math.min(depth[A], depth[B]);

        while (depth[A] != minDepth) {
            A = parent[A];
        }

        while (depth[B] != minDepth) {
            B = parent[B];
        }

        while (A != B) {
            A = parent[A];
            B = parent[B];
        }

        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            children = new ArrayList<>();
            depth = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                children.add(new ArrayList<>());
            }

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                children.get(A).add(B);
                parent[B] = A;
            }

            for (int i = 1; i <= N; i++) {
                if (parent[i] == 0) {
                    checkDepth(0, i);
                }
            }

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCA(A, B)).append("\n");
        }

        System.out.println(sb);
    }
}

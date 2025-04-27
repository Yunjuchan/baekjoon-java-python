import java.io.*;
import java.util.*;

public class Main {

    static int[] parents, depths;
    static boolean[] visited;

    static List<List<Integer>> adj;

    public static void setTree(int level, int now) {
        for (int next : adj.get(now)) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            depths[next] = level + 1;
            parents[next] = now;

            setTree(level + 1, next);
        }
    }

    public static int LCA(int A, int B) {
        int minDepth = Math.min(depths[A], depths[B]);

        while (depths[A] != minDepth) {
            A = parents[A];
        }

        while (depths[B] != minDepth) {
            B = parents[B];
        }

        while (A != B) {
            A = parents[A];
            B = parents[B];
        }

        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        depths = new int[N + 1];
        visited = new boolean[N + 1];

        adj = new ArrayList<>();
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
        visited[1] = true;
        depths[1] = 1;

        setTree(1, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCA(A, B)).append("\n");
        }

        System.out.println(sb);
    }
}

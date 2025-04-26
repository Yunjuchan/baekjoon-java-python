import java.io.*;
import java.util.*;

public class Main {

    static boolean isTree;
    static int n;
    static boolean[] visited;
    static List<List<Integer>> adj;

    public static void dfs(int now, int prev) {
        for (int next : adj.get(now)) {
            if (next == prev) {
                continue;
            }
            if (visited[next]) {
                isTree = false;
                continue;
            }
            visited[next] = true;
            dfs(next, now);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                System.out.println(sb);
                return;
            }

            int cnt = 0;
            adj = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj.get(a).add(b);
                adj.get(b).add(a);
            }

            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                isTree = true;
                visited[i] = true;
                dfs(i, -1);
                if (isTree) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                sb.append("Case ").append(tc).append(": No trees.").append("\n");
            } else if (cnt == 1) {
                sb.append("Case ").append(tc).append(": There is one tree.").append("\n");
            } else {
                sb.append("Case ").append(tc).append(": A forest of ").append(cnt).append(" trees.").append("\n");
            }
            tc++;
        }
    }
}

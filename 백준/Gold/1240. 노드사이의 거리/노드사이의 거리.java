import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<int[]>> adj;

    public static int distance(int s, int e) {

        boolean[] visited = new boolean[N + 1];
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] {s, 0});
        visited[s] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int[] next : adj.get(now[0])) {
                if (visited[next[0]]) {
                    continue;
                }
                visited[next[0]] = true;
                que.offer(new int[] {next[0], now[1] + next[1]});
                if (next[0] == e) {
                    return now[1] + next[1];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[] {b, c});
            adj.get(b).add(new int[] {a, c});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(distance(s, e)).append("\n");
        }

        System.out.println(sb);
    }
}

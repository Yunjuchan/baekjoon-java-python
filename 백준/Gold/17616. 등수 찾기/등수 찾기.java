import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static int bfs(int x, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N+1];
        visited[x] = true;
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : adj.get(now)) {
                if (visited[next]) {
                    continue;
                }
                que.offer(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();    // 나보다 낮은 사람
        List<List<Integer>> adj2 = new ArrayList<>();   // 나보다 높은 사람
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj.get(A).add(B);
            adj2.get(B).add(A);
        }

        int min = 1 + bfs(X, adj2);
        int max = N - bfs(X, adj);
        System.out.println(min + " " + max);
    }
}
import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            adj = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i=0; i<=N; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            int result = Integer.MAX_VALUE;
            for (int i=1; i<=N; i++) {
                int tmp = bfs(i);
                if (result > tmp) {
                    result = tmp;
                }
            }
            System.out.println(result);
        }
    }
    public static int bfs(int start) {
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : adj.get(now)) {
                if (visited[next]) { continue; }
                visited[next] = true;
                que.offer(next);
                cnt++;
            }
        }
        return cnt;
    }
}
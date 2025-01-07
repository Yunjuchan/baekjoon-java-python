import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 0;

        List<List<Integer>> adj = new ArrayList<>();
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

        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,1});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (now[0] == 2) {
                continue;
            }
            for (int next : adj.get(now[1])) {
                if (visited[next]) {
                    continue;
                }
                que.offer(new int[]{now[0]+1, next});
                visited[next] = true;
                result++;
            }
        }
        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }
        int dist = 0;
        int cnt = 0;
        int target = 1;
        boolean[] visited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj.get(A).add(B);
            adj.get(B).add(A);
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,1});
        visited[1] = true;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (now[0] == dist) {
                cnt++;
                target = Math.min(target, now[1]);
            } else {
                cnt = 1;
                dist = now[0];
                target = now[1];
            }
            for (int next : adj.get(now[1])) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                que.offer(new int[]{now[0]+1, next});
            }
        }

        System.out.println(target + " " + dist + " " + cnt);
    }
}
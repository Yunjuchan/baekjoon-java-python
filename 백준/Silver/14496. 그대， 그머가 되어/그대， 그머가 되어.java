import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b) {
                continue;
            }
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[N+1];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, A});
        visited[A] = true;
        int result = -1;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (now[1] == B) {
                result = now[0];
                break;
            }
            for (int next : adj.get(now[1])) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                que.add(new int[]{now[0]+1, next});
            }
        }

        System.out.println(result);
    }
}
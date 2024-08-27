import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());


        for (int i=0; i<N+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];

        for (int q=0; q<Q; q++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            int cnt = 0;

            if (visited2[x]) {
                sb.append(0).append("\n");
                continue;
            }
            visited2[x] = true;

            if (!visited[x]) {
                visited[x] = true;
                cnt++;
            }

            for (int next : adj.get(x)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
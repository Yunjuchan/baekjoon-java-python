import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int maxLength;
    static int s;
    static int time;
    static List<List<int[]>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }
        
        visited = new boolean[N + 1];
        maxLength = 0;
        time = Integer.MAX_VALUE;
        visited[1] = true;
        dfs(1, 0, 0);
        
        visited = new boolean[N + 1];
        maxLength = 0;
        time = Integer.MAX_VALUE;
        visited[s] = true;
        dfs(s, 0, 0);
        
        if (time % T > 0) {
            System.out.println(time / T + 1);
        } else {
            System.out.println(time / T);
        }
    }

    public static void dfs(int now, int cnt, int t) {
        if (cnt > maxLength) {
            maxLength = cnt;
            time = t;
            s = now;
        } else if (cnt == maxLength) {
            if (t < time) {
                time = t;
                s = now;
            }
        }

        for (int[] next : adj.get(now)) {
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                dfs(next[0], cnt + 1, t + next[1]);
                visited[next[0]] = false;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static char[] isIn;
    static boolean[] isVisited;
    static List<List<Integer>> adj;
    static long result;

    static void dfs(int i) {
        for (int next : adj.get(i)) {
            if (isVisited[next]) {
                continue;
            }
            if (isIn[next] == '1') {
                result++;
            } else {
                isVisited[i] = true;
                dfs(next);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        isIn = new char[N+1];
        result = 0;
        isVisited = new boolean[N+1];
        adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        String x = br.readLine();
        for (int i=1; i<=N; i++) {
            isIn[i] = x.charAt(i-1);
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i=1; i<=N; i++) {
            if (isIn[i] == '1') {
                dfs(i);
            }
        }
        System.out.println(result);
    }
}
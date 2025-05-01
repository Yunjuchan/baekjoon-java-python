import java.io.*;
import java.util.*;

public class Main {

    static int[] result, compliment;
    static List<List<Integer>> children;

    static void dfs(int now, int w) {
        result[now] = w;
        for (int next : children.get(now)) {
            dfs(next, w + compliment[next]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        children = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            children.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                children.get(p).add(i);
            }
        }

        compliment = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            compliment[idx] += w;
        }

        dfs(1, compliment[1]);

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}

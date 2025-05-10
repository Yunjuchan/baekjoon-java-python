import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] miro = new int[N + 1];
        int[] visited = new int[N + 1];

        Arrays.fill(visited, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 1});
        visited[1] = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 1; i <= miro[cur[1]]; i++) {
                int next = cur[1] + i;
                if (next > N || visited[next] != -1) {
                    continue;
                }
                visited[next] = cur[0] + 1;
                que.offer(new int[] {visited[next], next});
            }
        }

        System.out.println(visited[N]);
    }
}

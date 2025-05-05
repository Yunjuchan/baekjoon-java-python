import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int[] move = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move[u] = v;
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 1});
        visited[1] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cnt = cur[0];
            int now = cur[1];
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next == 100) {
                    System.out.println(cnt + 1);
                    return;
                }
                if (next > 100) {
                    continue;
                }
                if (visited[move[next]]) {
                    continue;
                }
                visited[move[next]] = true;
                que.offer(new int[] {cnt + 1, move[next]});
            }
        }
    }
}

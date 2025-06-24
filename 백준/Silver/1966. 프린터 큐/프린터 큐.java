import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<int[]> que = new LinkedList<>();
            int[] priority = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                que.offer(new int[] {i, p});
                priority[i] = -p;
            }

            Arrays.sort(priority);

            for (int i = 0; i < N; i++) {
                priority[i] = -priority[i];
            }

            int order = 0;
            
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                if (priority[order] == cur[1]) {
                    order++;
                    if (target == cur[0]) {
                        sb.append(order).append("\n");
                    }
                } else {
                    que.offer(cur);
                }
            }
        }

        System.out.println(sb);
    }
}
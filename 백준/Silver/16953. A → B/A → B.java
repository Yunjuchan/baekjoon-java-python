import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<long[]> que = new LinkedList<>();
        que.offer(new long[] {1, A});

        while (!que.isEmpty()) {
            long[] cur = que.poll();

            if (cur[1] * 2 < B) {
                que.offer(new long[] {cur[0] + 1, cur[1] * 2});
            } else if (cur[1] * 2 == B) {
                System.out.println(cur[0] + 1);
                return;
            }

            if (cur[1] * 10 + 1 < B) {
                que.offer(new long[] {cur[0] + 1, cur[1] * 10 + 1});
            } else if (cur[1] * 10 + 1 == B) {
                System.out.println(cur[0] + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
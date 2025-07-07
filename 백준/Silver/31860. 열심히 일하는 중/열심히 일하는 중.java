import java.io.*;
import java.util.*;
public class Main {

    static final int MOD = 1_000_000_003;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());
            que.offer(-p);
        }

        int s = 0;
        int d = 0;
        while (!que.isEmpty()) {
            int p = -que.poll();
            d++;
            s = s / 2 + p;
            sb.append(s).append("\n");
            if (K >= p - M) {
                continue;
            }
            que.offer(M - p);
        }

        System.out.println(d);
        System.out.println(sb);
    }
}
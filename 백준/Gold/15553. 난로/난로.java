import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.MAX_VALUE;
        int E = 0;
        Queue<Integer> que = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            que.offer(n);
            S = Math.min(S, n);
            E = Math.max(E, n+1);
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        Queue<Integer> que2 = new PriorityQueue<>();

        int prev = que.poll();
        while (!que.isEmpty()) {
            int next = que.poll();
            que2.offer(prev+1 - next);
            prev = next;
        }

        int cnt = 1;
        int total = E - S;

        while (!que2.isEmpty() && cnt < K) {
            int x = que2.poll();
            total += x;
            cnt++;
        }
        System.out.println(total);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        List<Queue<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new LinkedList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                adj.get(i).offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N; i++) {
            while (adj.get(i).size() > M) {
                cnt++;
                if (cnt > K) {
                    System.out.println(0);
                    return;
                }
                adj.add(new LinkedList<>());
                int idx = 0;

                while (!adj.get(i).isEmpty() && idx < M) {
                    idx++;
                    adj.get(N + cnt).add(adj.get(i).poll());
                }
                adj.get(i).add(N + cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n").append(cnt).append("\n");
        for (int i = 1; i <= N + cnt; i++) {
            sb.append(adj.get(i).size()).append(" ");
            for (int c : adj.get(i)) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
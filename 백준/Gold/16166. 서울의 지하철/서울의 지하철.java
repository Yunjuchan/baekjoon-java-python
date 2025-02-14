import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        boolean[] visitedSubway = new boolean[N];
        List<List<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> route = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            route.add(new HashSet<>());
            adj.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int station = Integer.parseInt(st.nextToken());
                route.get(i).add(station);
                if (station == 0) {
                    que.add(new int[]{i, 0});
                    visitedSubway[i] = true;
                }
                for (int k = 0; k < i; k++) {
                    if (route.get(k).contains(station)) {
                        adj.get(i).add(k);
                        adj.get(k).add(i);
                    }
                }
            }
        }

        int target = Integer.parseInt(br.readLine());
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int subway = now[0];
            int exchange = now[1];

            if (route.get(subway).contains(target)) {
                System.out.println(exchange);
                return;
            }

            for (int next : adj.get(subway)) {
                if (visitedSubway[next]) {
                    continue;
                }
                visitedSubway[next] = true;
                que.offer(new int[]{next, exchange + 1});
            }
        }

        System.out.println(-1);
    }
}
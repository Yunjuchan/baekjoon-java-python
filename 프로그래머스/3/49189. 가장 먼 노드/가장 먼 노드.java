import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist = new int[n + 1];
        int far = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        Queue<Integer> que = new LinkedList<>();
        dist[1] = 0;
        que.offer(1);
        
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : adj.get(now)) {
                // System.out.println("now: " + now + " next: " + next + " dist[now] : " + dist[now] + " dist[next]: "  + dist[next]);
                if (dist[next] <= dist[now] + 1) {
                    continue;
                }
                dist[next] = dist[now] + 1;
                que.offer(next);
                if (far < dist[next]) {
                    far = dist[next];
                    answer = 1;
                } else if (far == dist[next]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    
    static int cnt;
    
    static boolean[] visited;
    static List<List<Integer>> adj;
    
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            cnt++;
            for (int next : adj.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                que.offer(next);
            }
        }
    }
        
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        adj = new ArrayList<>();
        boolean[][] adjArr = new boolean[n+1][n+1];
        
        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int s = wire[0];
            int e = wire[1];
            adj.get(s).add(e);
            adj.get(e).add(s);
            adjArr[s][e] = true;
            adjArr[e][s] = true;
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (!adjArr[i][j]){
                    continue;
                }
                visited = new boolean[n+1];
                visited[i] = true;
                visited[j] = true;
                
                cnt = 0;
                bfs(i);
                int x = cnt;
                bfs(j);
                int tmp = Math.abs(cnt - 2 * x);
                if (answer > tmp) {
                    answer = tmp;
                }
            }
        }
        
        return answer;
    }
}
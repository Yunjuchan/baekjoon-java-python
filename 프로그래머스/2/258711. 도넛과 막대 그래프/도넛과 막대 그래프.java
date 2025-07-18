import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] inOut;
    public static List<List<Integer>> adj;
    
    public static int bfs(int s) {
        Queue<Integer> que = new LinkedList<>();
        boolean hasCycle = false;
        
        visited[s] = true;
        que.offer(s);
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (inOut[cur][0] == 2) {
                return 3;
            }
            for (int next : adj.get(cur)) {
                if (visited[next]) {
                    hasCycle = true;
                    continue;
                }
                que.offer(next);
            }
        }
        
        if (hasCycle) {
            return 1;
        } else {
            return 2;
        }
    }
    
    public int[] solution(int[][] edges) {
        int n = edges.length;
        int[] answer = new int[4];
        visited = new boolean[1_000_001];
        boolean[] isStart = new boolean[1_000_001];
        inOut = new int[1_000_001][2];
        
        adj = new ArrayList<>();
        for (int i = 0; i <= 1_000_000; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            isStart[edge[0]] = true;
        }
        
        for (int[] edge : edges) {
            inOut[edge[0]][0]++;
            inOut[edge[1]][1]++;
            adj.get(edge[0]).add(edge[1]);
            isStart[edge[1]] = false;
        }
        
        for (int i = 1; i <= 1_000_000; i++) {
            if (isStart[i] && adj.get(i).size() >= 2) {
                answer[0] = i;
            }
        }
        
        int start = answer[0];
        
        for (int cur : adj.get(start)) {
            answer[bfs(cur)]++;
        }
        
        return answer;
    }
}
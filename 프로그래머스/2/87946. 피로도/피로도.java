class Solution {
    
    static boolean[] visited;
    static int answer = -1;
    
    public static void dfs(int n, int k, int[][] dungeons) {
        if (answer < n) {
            answer = n;
        }
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(n+1, k-dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
}
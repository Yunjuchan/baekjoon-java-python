class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] adj = new int[n + 1][n + 1];
        
        for (int[] result : results) {
            int A = result[0];
            int B = result[1];
            adj[A][B] = 1;
            adj[B][A] = -1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (k == j || i == j) {
                        continue;
                    }
                    if (adj[i][k] == 1 && adj[k][j] == 1) {
                        adj[i][j] = 1;
                        adj[j][i] = -1;
                    } else if (adj[i][k] == -1 && adj[k][j] == -1) {
                        adj[i][j] = -1;
                        adj[j][i] = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int zeroCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 0) {
                    zeroCnt++;
                }
            }
            
            if (zeroCnt == 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
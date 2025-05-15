import java.util.*;

class Solution {
    
    static int answer;
    static int[] par;
    
    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }
    
    public static void union(int a, int b, int w) {
        int fa = find(a);
        int fb = find(b);
        
        if (fa == fb) {
            return;
        }
        par[fb] = fa;
        answer += w;
    }
    
    public int solution(int n, int[][] costs) {
        answer = 0;
        par = new int[n];
        
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for (int[] cost : costs) {
            if (cost[0] > cost[1]) {
                int tmp = cost[0];
                cost[0] = cost[1];
                cost[1] = tmp;
            }
            union(cost[0], cost[1], cost[2]);
            // System.out.println(cost[0] + " " + cost[1] + " " + cost[2]);
        }
        return answer;
    }
}
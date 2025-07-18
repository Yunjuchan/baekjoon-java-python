import java.util.*;

class Solution {
    static int maxN, m, answer;
    static int[] ansCnt;
    static int[][] arr;

    public static void dfs(int level, int start, Set<Integer> set) {
        
        if (level == 5) {
            for (int i = 0; i < m; i++) {
                int cnt = 0;
                
                for (int j = 0; j < 5; j++) {
                    if (set.contains(arr[i][j])) {
                        cnt++;
                    }
                }
                
                if (cnt != ansCnt[i]) {
                    return;
                }
            }
            answer++;
            return;
        }
        
        if (start > maxN) {
            return;
        }
        
        set.add(start);
        dfs(level + 1, start + 1, set);
        set.remove(start);
        dfs(level, start + 1, set);
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        maxN = n;
        m = q.length;
        ansCnt = ans.clone();
        arr = new int[m][5];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = q[i][j];
            }
        }
        
        answer = 0;
        dfs(0, 1, new HashSet<>());
        return answer;
    }
}
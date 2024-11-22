import java.util.*;
import java.io.*;

class Solution {
    
    static int result = 0;
    static int[] H;
    
    public static void dfs(int level, int N, int B, int total) {
        if (total-B >= result) {
            return;
        }
     	if (level == N) {
            if (total >= B) {
            	
                result = Math.min(result, total-B);
            }
            return;
        }
        dfs(level+1, N, B, total+H[level]);
        dfs(level+1, N, B, total);
    }
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            
            H = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0, N, B, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
}
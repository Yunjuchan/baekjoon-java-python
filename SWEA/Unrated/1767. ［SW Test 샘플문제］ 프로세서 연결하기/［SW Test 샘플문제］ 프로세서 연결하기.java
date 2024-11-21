import java.util.*;
import java.io.*;

class Solution {
    
    static int N, maxCount, minLength;
    static int[][] arr;
    static int[] directY = {1,0,-1,0};
    static int[] directX = {0,1,0,-1};
    static List<int[]> cores;
    
    public static void dfs(int level, int K, int count, int length) {
        if (count + (K - level) < maxCount) return;
        if (level == K) {
            if (count > maxCount || (count == maxCount && length < minLength)) {
                maxCount = count;
                minLength = length;
            }
            return;
        }
        int y = cores.get(level)[0];
        int x = cores.get(level)[1];
        if (y == 0 || x == 0 || y == N-1 || x == N-1) {
            dfs(level+1, K, count+1, length);
        } else {
            // ---------------------------
            for (int i=0; i<4; i++) {
                boolean flag = true;
                int ny = y;
                int nx = x;
                while (true) {
                    ny += directY[i];
                    nx += directX[i];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        break;
                    }
                    if (arr[ny][nx] != 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ny = y;
                    nx = x;
                    int l = 0;
                    while (true) {
                        ny += directY[i];
                        nx += directX[i];
                        if (ny < 0 || nx <0 || ny >= N || nx >= N) {
                            break;
                        }
                        l++;
                        arr[ny][nx] = 2;
                    }
                    
                    dfs(level+1, K, count+1, length+l);
                    ny = y;
                    nx = x;
                    while (true) {
                        ny += directY[i];
                        nx += directX[i];
                        if (ny < 0 || nx <0 || ny >= N || nx >= N) {
                            break;
                        }
                        arr[ny][nx] = 0;
                    }
                } 
                dfs(level+1, K, count, length);
            }
            // ---------------------------
        }
    }
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int T= Integer.parseInt(st.nextToken());
	
		for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            cores = new ArrayList<>();
            maxCount = 0;
        	minLength = Integer.MAX_VALUE;
            
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }
            
            dfs(0, cores.size(), 0, 0);
			System.out.println("#" + tc + " " + minLength);
		}
	}
}
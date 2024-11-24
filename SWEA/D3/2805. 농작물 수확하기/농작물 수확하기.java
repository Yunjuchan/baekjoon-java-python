import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
			for (int i=0; i<N; i++) {
                String line = br.readLine();
                for (int j=0; j<N; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                }
            }
            int result = 0;
            
            for (int i=0; i<N; i++) {
                int start, end;
                if (i <= N/2) {
                    start = N/2 - i;
                    end = N/2 + i;
                } else {
                    start = N/2 - (N - 1 - i);
                    end = N/2 + (N - 1 - i);
                }
                for (int j=start; j<=end; j++) {
                    result += arr[i][j];
                }
            }
            System.out.println("#" + tc + " " + result);
		}
	}
}
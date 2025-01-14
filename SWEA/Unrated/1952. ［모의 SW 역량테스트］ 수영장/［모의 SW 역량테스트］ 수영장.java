import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {
            int[] fee = new int[4];
            int[] month = new int[12];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<4; i++) {
                fee[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[12];
            dp[0] = Math.min(fee[0] * month[0], fee[1]);
            for (int i=1; i<12; i++) {
                dp[i] = dp[i-1] + Math.min(fee[0] * month[i], fee[1]);
            }
            
			if (dp[2] > fee[2]) {
            	dp[2] = Math.min(dp[2], fee[2]);
                for (int i=3; i<12; i++) {
                        dp[i] = dp[i-1] + Math.min(fee[0] * month[i], fee[1]);
                    }
            }
            
            for (int i=3; i<12; i++) {
                if (dp[i] > dp[i-3] + fee[2]) {
                    dp[i] = dp[i-3] + fee[2];
                    for (int j=i+1; j<12; j++) {
                        dp[j] = dp[j-1] + Math.min(fee[0] * month[j], fee[1]);
                    }
                }
            }

            int result = Math.min(fee[3], dp[11]);

            System.out.println("#" + tc + " " + result);
        }
    }
}
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
                if (i == 2) {
                    dp[i] = Math.min(dp[i], fee[2]);
                } else if (i > 2) {
                    dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
                }
            }

            int result = Math.min(fee[3], dp[11]);

            System.out.println("#" + tc + " " + result);
        }
    }
}
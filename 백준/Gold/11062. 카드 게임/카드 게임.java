import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] cards = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N][N];
            int[] sum = new int[N];
            sum[0] = cards[0];
            for (int i = 1; i < N; i++) {
                sum[i] = sum[i - 1] + cards[i];
            }

            for (int len=1; len<=N; len++) {
                for (int i=0; i<=N-len; i++) {
                    int j = i + len - 1;
                    int s = sum[j] - (i > 0 ? sum[i-1] : 0);
                    if (i == j) {
                        dp[i][j] = cards[i];
                    } else {
                        dp[i][j] = Math.max(s - dp[i+1][j], s - dp[i][j-1]);
                    }
                }
            }
            System.out.println(dp[0][N-1]);
        }
    }
}
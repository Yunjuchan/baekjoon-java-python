import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int MOD = 100000;

        int[][][][] dp = new int[w+1][h+1][2][2];

        for (int i=1; i<=w; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int i=1; i<=h; i++) {
            dp[1][i][1][0] = 1;
        }

        for (int i=2; i<=w; i++) {
            for (int j=2; j<=h; j++) {

                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i-1][j][1][0] % MOD;
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % MOD;
                dp[i][j][1][1] = dp[i][j-1][0][0] % MOD;
            }
        }

        int result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % MOD;
        System.out.println(result);
    }
}
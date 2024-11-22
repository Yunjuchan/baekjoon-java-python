import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][10];
        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }
        for (int i=2; i<=N; i++) {
            for (int j=0; j<10; j++) {
                for (int k=j; k<10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }

            }
        }
        int result = 0;
        for (int i=0; i<10; i++) {
            result += dp[N][i];
            result %= 10007;
        }
        System.out.println(result);
    }
}
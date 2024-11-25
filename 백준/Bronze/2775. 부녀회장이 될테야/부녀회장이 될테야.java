import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[][] dp = new int[15][15];

        for (int i=0; i<15; i++) {
            dp[0][i] = i;
        }
        for (int i=1; i<15; i++) {
            for (int j=1; j<15; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            System.out.println(dp[N][K]);
        }

    }
}
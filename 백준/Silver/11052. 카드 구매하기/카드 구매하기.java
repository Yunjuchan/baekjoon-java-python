import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] price = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = price[1];
        for (int i=2; i<=N; i++) {
            for (int j=0; j<i; j++) {
                dp[i] = Math.max(dp[i], price[i-j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
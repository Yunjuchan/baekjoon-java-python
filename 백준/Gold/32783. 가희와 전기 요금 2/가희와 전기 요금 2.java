import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] computers = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            double cost = a * m / 60000 * 96;
            computers[i] = (long) cost;
        }

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        long[] dp = new long[c2 + 1];

        dp[0] = 1;

        for (long computer : computers) {
            if (computer > c2) {
                continue;
            }
            for (int j = c2; j >= computer; j--) {
                dp[j] = (dp[j] + dp[(int) (j - computer)]) % MOD;
            }
        }
        
        long result = 0;
        for (int i = c1; i <= c2; i++) {
            result = (result + dp[i]) % MOD;
        }

        System.out.println(result);
    }
}

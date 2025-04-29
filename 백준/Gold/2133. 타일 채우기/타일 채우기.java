import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        if (N >= 2) {
            dp[2] = 3;
        }
        if (N >= 4) {
            dp[4] = 11;
        }

        for (int i = 6; i <= N; i += 2) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }

        System.out.println(dp[N]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

            if (N == 0 && M == 0) {
                break;
            }

            int[] dp = new int[M + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

                for (int j = p; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            System.out.println(dp[M]);
        }
    }
}
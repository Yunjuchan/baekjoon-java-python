import java.beans.beancontext.BeanContextChildComponentProxy;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[][] dp = new long[31][31];

        for (int i=0; i<=30; i++) {
            dp[0][i] = 1;
        }
        dp[1][1] = 1;
        dp[2][2] = 2;
        for (int i=3; i<=30; i++) {
            long total = 0;
            long tmp = 0;
            for (int j=0; j<i; j++) {
                tmp += dp[j][i-2];
                dp[j][i-1] = tmp;
                total += tmp;

            }
            dp[i][i] = total;
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            System.out.println(dp[N][N]);
        }
    }
}
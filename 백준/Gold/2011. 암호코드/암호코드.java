import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String number = br.readLine();
        int N = number.length();
        int[] dp = new int[N];
        if (number.charAt(0) == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i=1; i<N; i++) {
            if (number.charAt(i) != '0') {
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }
            String tmp = number.substring(i-1, i+1);
            int n = Integer.parseInt(tmp);
            if (n >= 10 && n <= 26) {
                if (i == 1) {
                    dp[1]++;
                } else {
                    dp[i] += dp[i-2];
                    dp[i] %= 1000000;
                }
            }
        }
        System.out.println(dp[N-1]);
    }
}
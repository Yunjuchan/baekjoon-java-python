import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String sentence = br.readLine();
        int N = sentence.length();
        int[][] dp = new int[2][N];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        if (sentence.charAt(0) >= 'A' && sentence.charAt(0) <= 'Z') {
            dp[0][0] = 2; // 소문자 + 별
            dp[1][0] = 2; // 마름모 + 대문자
        } else {
            dp[0][0] = 1; // 소문자
            dp[1][0] = 2; // 소문자 + 마름모
        }

        for (int i = 1; i < N; i++) {
            char c = sentence.charAt(i);
            if (c >= 'A' && c <= 'Z') { // 대문자 일 때
                dp[0][i] = Math.min(dp[1][i - 1] + 2, dp[0][i - 1] + 2);
                dp[1][i] = Math.min(dp[1][i - 1] + 1, dp[0][i - 1] + 2);
            } else { // 소문자 일 때
                dp[0][i] = Math.min(dp[1][i - 1] + 2, dp[0][i - 1] + 1);
                dp[1][i] = Math.min(dp[1][i - 1] + 2, dp[0][i - 1] + 2);
            }
        }
        System.out.println(Math.min(dp[0][N - 1], dp[1][N - 1]));
    }
}
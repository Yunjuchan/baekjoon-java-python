import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[M][N];

        String word1 = br.readLine();
        String word2 = br.readLine();

        for (int j = 0; j < N; j++) {
            if(word1.charAt(j) == word2.charAt(0)){
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int j = 0; j < N; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j)) {
                    if (dp[i - 1][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    for (int k = 0; k < N; k++) {
                        if (word1.charAt(j) == word1.charAt(k)) {
                            // 왼쪽 확인
                            if (k >= 1 && word2.charAt(i) == word1.charAt(k - 1)) {
                                dp[i][k - 1] = Math.min(dp[i][k - 1], dp[i - 1][j] + Math.abs(k - j) + 1);
                            }

                            // 오른쪽 확인
                            if (k < N - 1 && word2.charAt(i) == word1.charAt(k + 1)) {
                                dp[i][k + 1] = Math.min(dp[i][k + 1], dp[i - 1][j] + Math.abs(k - j) + 1);
                            }
                        }
                    }
                }
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.min(result, dp[M-1][i]);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] dp = new int[N + 1][2];
        dp[0][0] = -1;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            dp[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][1] > dp[j][1]) {
                    result = Math.max(result, j + 1);
                    if (arr[i][1] < dp[j + 1][1]) {
                        dp[j + 1][0] = i;
                        dp[j + 1][1] = arr[i][1];
                    }
                }
            }
        }

        System.out.println(N - result);
    }
}

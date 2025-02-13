import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int max = 0;
        int result = Integer.MAX_VALUE;

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    max = Math.max(max, arr[i][0]);
                }
            }
        }

        int[] dp = new int[H + max];
        Arrays.fill(dp, 100_000_000);
        dp[0] = 0;


//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                double a = (double) o1[0] / o1[1];
//                double b = (double) o2[0] / o2[1];
//                return Double.compare(a, b);
//            }
//        });

        for (int i = 0; i < N; i++) {
            for (int j = arr[i][0]; j < H + max; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i][0]] + arr[i][1]);
                if (j >= H) {
                    result = Math.min(result, dp[j]);
                }
            }
        }

        System.out.println(result);
    }
}
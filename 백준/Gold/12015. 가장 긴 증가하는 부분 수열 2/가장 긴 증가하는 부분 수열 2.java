import java.io.*;
import java.util.*;

public class Main {

    /**
     * 최장 증가하는 부분 수열 O(N * logN) 풀이
     */
    static int N;
    static int[] X;
    public static int binarySearch(int target, int e) {
        int s = 0;
        int x = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid >= N) {
                break;
            }
            if (X[mid] < target) {
                s = mid + 1;
                x = mid;
            } else if (X[mid] >= target) {
                e = mid - 1;
            }
        }

        X[x + 1] = Math.min(X[x + 1], target);

        return x + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int max = 1;
        int[] arr = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 최장 증가하는 부분 수열 O(N * N) 풀이
         */
//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] > arr[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
        /**
         * 최자 증가하는 부분 수열 O(N * logN) 푸링
         */
        X = new int[N + 1];
        Arrays.fill(X, Integer.MAX_VALUE);
        X[0] = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = binarySearch(arr[i], i);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
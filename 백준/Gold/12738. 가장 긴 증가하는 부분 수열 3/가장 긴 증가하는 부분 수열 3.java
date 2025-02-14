import java.io.*;
import java.util.*;

public class Main {

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

        X = new int[N + 1];
        Arrays.fill(X, Integer.MAX_VALUE);
        X[0] = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            dp[i] = binarySearch(arr[i], i);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
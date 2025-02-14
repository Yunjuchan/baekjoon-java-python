import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] X;
    static int[] prev;

    public static int binarySearch(int target, int idx) {
        int s = 0, e = idx;
        int x = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid >= N) {
                break;
            }

            if (X[mid][0] < target) {
                s = mid + 1;
                x = mid;
            } else if (X[mid][0] >= target) {
                e = mid - 1;
            }
        }

        X[x + 1][0] = Math.min(X[x + 1][0], target);
        prev[idx] = X[x][1];
        X[x + 1][1] = idx;

        return x + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int max = 1;
        int[] arr = new int[N];
        int[] dp = new int[N];
        prev = new int[N];

        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            X[i][0] = Integer.MAX_VALUE;
        }

        X[0][0] = Integer.MIN_VALUE;
        X[0][1] = -1;

        for (int i = 0; i < N; i++) {
            dp[i] = binarySearch(arr[i], i);
            max = Math.max(max, dp[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        int now = X[max][1];
        

        Stack<Integer> stack = new Stack<>();
        while (now != -1) {
            stack.add(now);
            now = prev[now];
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            sb.append(arr[idx]).append(" ");
        }

        System.out.println(sb);
    }
}
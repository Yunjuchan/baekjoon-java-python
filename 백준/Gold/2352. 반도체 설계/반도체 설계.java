import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] prev;
    static int[][] X;

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

        int[] ports = new int[N];
        prev = new int[N];
        X = new int[N + 1][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ports[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            X[i][0] = Integer.MAX_VALUE;
        }

        X[0][0] = Integer.MIN_VALUE;
        X[0][1] = -1;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, binarySearch(ports[i], i));
        }

        System.out.println(max);
    }
}

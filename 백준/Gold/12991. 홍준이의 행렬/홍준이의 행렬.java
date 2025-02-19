import java.io.*;
import java.util.*;

public class Main {
    static int N;

    private static long countLessOrEqual(long[] A, long[] B, long X) {
        long count = 0;
        int j = N - 1;

        for (int i = 0; i < N; i++) {
            while (j >= 0 && A[i] * B[j] > X)  {
                j--;
            }
            count += (j + 1);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        long[] B = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        long left = A[0] * B[0];
        long right = A[N - 1] * B[N - 1];
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(A, B, mid) >= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
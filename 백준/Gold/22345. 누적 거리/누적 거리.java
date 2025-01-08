import java.io.*;
import java.util.*;

public class Main {
    public static int lowerBound(List<int[]> arr, int q) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid)[1] <= q) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<int[]> arr = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr.add(new int[]{a, x});
        }

        arr.sort((o1, o2) -> o1[1] - o2[1]);

        long[] aSum = new long[N];
        long[] axSum = new long[N];
        aSum[0] = arr.get(0)[0];
        axSum[0] = (long) arr.get(0)[0] * arr.get(0)[1];
        for (int i=1; i<N; i++) {
            aSum[i] = aSum[i-1] + arr.get(i)[0];
            axSum[i] = axSum[i-1] + (long) arr.get(i)[0] * arr.get(i)[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            int q = Integer.parseInt(br.readLine());

            int idx = lowerBound(arr, q);
            long leftSum, rightSum;
            if (idx < 0) {
                leftSum = 0;
                rightSum = axSum[N-1] - aSum[N-1] * q;
            } else {
                leftSum = aSum[idx] * q - axSum[idx];
                rightSum = (axSum[N-1] - axSum[idx]) - (aSum[N-1] - aSum[idx]) * q;
            }
            sb.append(leftSum + rightSum).append("\n");
        }
        System.out.print(sb);
    }
}
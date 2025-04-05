import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dots;

    public static int upperBound(int end) {
        int idx = -1;

        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (dots[mid] <= end) {
                idx = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return idx;
    }

    public static int lowerBound(int start) {
        int idx = N;

        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (dots[mid] < start) {
                s = mid + 1;
            } else {
                idx = mid;
                e = mid - 1;
            }
        }
        return idx;
    }

    public static int count(int start, int end) {
        int lowerIdx = lowerBound(start);
        int upperIdx = upperBound(end);

        return upperIdx - lowerIdx + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dots = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dots);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(count(start, end)).append("\n");
        }
        System.out.println(sb);
    }
}

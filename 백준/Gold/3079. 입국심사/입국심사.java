import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] T = new long[N];
        long s = 0;
        long e = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, M * T[i]);
        }

        while (s <= e) {
            long mid = (s + e) / 2;

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid / T[i];
                if (cnt > M) {
                    break;
                }
            }

            if (cnt >= M) {
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(result);
    }
}
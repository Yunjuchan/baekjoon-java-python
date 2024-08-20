import java.io.*;
import java.util.*;

public class Main {
    static long f(long x) {
        long result = 1;
        result = result * x * (x+1) / 2;
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = 0;
        long res = 0;
        long s = 0;
        long e = Integer.MAX_VALUE;
        while (true) {

            long mid = (s + e) / 2;
            if (N > f(mid-1) && N <= f(mid)) {
                K = mid;
                res = N - f(mid-1);
                break;
            } else if (N <= f(mid-1)) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        if (K % 2 == 1) {
            System.out.printf("%d/%d", K-res+1, res);
        } else {
            System.out.printf("%d/%d", res, K-res+1);
        }
    }
}
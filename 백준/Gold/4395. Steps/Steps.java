import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long diff = y - x;

            long n = 0;
            long s = 0;
            long e = diff;
            while (s <= e) {
                long mid = (s + e) / 2;
                if (mid * (mid+1) < diff) {
                    s = mid + 1;
                } else {
                    n = mid;
                    e = mid - 1;
                }
            }

            long cnt = 2 * n;
            if (diff - n * (n-1) <= n) {
                cnt--;
            }

            System.out.println(Math.max(cnt, 0));
        }
    }
}
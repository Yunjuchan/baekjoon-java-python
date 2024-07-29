import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long s = 0;
        long e = (long) Math.sqrt(Long.MAX_VALUE);
        long result = (long) Math.sqrt(Long.MAX_VALUE)+1;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (mid * mid >= N) {
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(result);
    }
}
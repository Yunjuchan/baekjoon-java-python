import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long s = 0;
        long e = (N + 1) / 2;

        while (s <= e) {
            long mid = (s + e) / 2;
            long count = (mid + 1) * (N - mid + 1);
            if (count > k) {
                e = mid - 1;
            } else if (count < k) {
                s = mid + 1;
            } else {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}

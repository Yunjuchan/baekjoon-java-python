import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long monkey = Long.parseLong(st.nextToken());
        long dog = Long.parseLong(st.nextToken());
        long diff = dog - monkey;
        if (diff == 0) {
            System.out.println(0);
            return;
        }
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

        long day = 2 * n;
        if (diff - n * (n-1) <= n) {
            day--;
        }

        System.out.println(day);
    }
}
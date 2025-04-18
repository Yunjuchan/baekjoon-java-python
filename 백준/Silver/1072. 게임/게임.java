import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = 100 * Y / X;
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int result = 0;

        int s = 0;
        int e = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (Z != 100 * (Y + mid) / (X + mid)) {
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(result);
    }
}
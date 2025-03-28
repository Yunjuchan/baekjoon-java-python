import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] rest = new int[N + 2];
        int result = Integer.MAX_VALUE;
        rest[0] = 0;
        rest[N + 1] = L;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rest);

        int s = 1;
        int e = L;

        while (s <= e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i = 0; i <= N; i++) {
                int diff = rest[i + 1] - rest[i];
                diff += mid - 1;
                cnt += diff / mid;
            }

            if (cnt > N + M + 1) {
                s = mid + 1;
            } else {
                result = Math.min(result, mid);
                e = mid - 1;
            }
        }

        System.out.println(result);
    }
}

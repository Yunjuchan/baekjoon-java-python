import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = (N - 1) / H + 1;
            int y = (N % H) == 0 ? H : N % H;
            System.out.println(100 * y + x);
        }
    }
}
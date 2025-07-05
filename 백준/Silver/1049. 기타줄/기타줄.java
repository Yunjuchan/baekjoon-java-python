import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packageMin = Integer.MAX_VALUE;
        int eachMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            packageMin = Math.min(packageMin, p);
            eachMin = Math.min(eachMin, e);
        }

        int min = Integer.MAX_VALUE;
        if (packageMin > eachMin * 6) {
            min = eachMin * N;
        } else {
            int packageCnt = N / 6;
            int eachCnt = N % 6;
            min = packageCnt * packageMin + eachCnt * eachMin;
            min = Math.min(min, (packageCnt + 1) * packageMin);
        }

        System.out.println(min);
    }
}
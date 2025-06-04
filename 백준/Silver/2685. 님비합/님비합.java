import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static long nimSum(long B, long X, long Y) {
        String x = "";
        int l = String.valueOf(B).length();
        for (int i = 10; i <= 1_000_000; i*=10) {
            if (B == i) {
                l--;
                break;
            }
        }

        while (X != 0) {
            long res = X % B;
            int rl = String.valueOf(res).length();
            x = "0".repeat(l - rl) + res + x;
            X /= B;
        }

        String y = "";
        while (Y != 0) {
            long res = Y % B;
            int rl = String.valueOf(res).length();
            y = "0".repeat(l - rl) + res + y;
            Y /= B;
        }

        if (x.length() < y.length()) {
            x = "0".repeat(y.length() - x.length()) + x;
        } else {
            y = "0".repeat(x.length() - y.length()) + y;
        }

        long xy = 0;
        for (int i = 0; i < x.length(); i+= l) {
            long tmp = Long.parseLong(x.substring(i, i + l)) + Long.parseLong(y.substring(i, i + l));
            if (tmp >= B) {
                tmp -= B;
            }
            xy += tmp * (long) (Math.pow(B, (x.length() / l) - (i / l) - 1));
        }

        return xy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long B = Integer.parseInt(st.nextToken());
            long X = Integer.parseInt(st.nextToken());
            long Y = Integer.parseInt(st.nextToken());
            sb.append(nimSum(B, X, Y)).append("\n");
        }

        System.out.println(sb);
    }
}
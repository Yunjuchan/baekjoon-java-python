import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void hanoi(int n, int start, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        int left = 6 - start - end;

        hanoi(n - 1, start, left);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, left, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        BigInteger cnt = BigInteger.TWO;
        cnt = cnt.pow(N).subtract(BigInteger.ONE);
        if (N > 20) {
            System.out.println(cnt);
            return;
        }

        System.out.println(cnt);

        hanoi(N, 1, 3);
        System.out.println(sb);
    }
}
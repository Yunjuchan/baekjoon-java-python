import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = R - N*M;
        int min = Math.min(K, N-1);
        BigInteger result = BigInteger.ONE;
        if (K < 0) {
            result = BigInteger.ZERO;
        } else {
            for (int i = 0; i < min; i++) {
                result = result.multiply(BigInteger.valueOf(K + N - 1 - i));
                result = result.divide(BigInteger.valueOf(i + 1));
            }
        }
        System.out.println(result);
    }

}
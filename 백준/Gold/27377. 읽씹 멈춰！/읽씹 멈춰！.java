import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            BigInteger N = new BigInteger(br.readLine());
            st = new StringTokenizer(br.readLine());
            BigInteger s = new BigInteger(st.nextToken());
            BigInteger t = new BigInteger(st.nextToken());

            BigInteger total = BigInteger.ZERO;

            while (N.compareTo(BigInteger.ZERO) > 0) {
                if (N.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                    total = total.add(s);
                    N = N.subtract(BigInteger.ONE);
                } else {
                    BigInteger half = N.divide(BigInteger.TWO);
                    BigInteger copyPasteTime = half.multiply(s);
                    total = total.add(copyPasteTime.min(t));
                    N = half;
                }
            }

            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}
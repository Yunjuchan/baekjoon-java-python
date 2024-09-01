import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static class Voice {
        BigInteger A;
        BigInteger B;
        int n;

        public Voice(BigInteger A, BigInteger B, int n) {
            this.A = A;
            this.B = B;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Double, Voice> M = new TreeMap<>();
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String result = "-1";
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            BigInteger A = BigInteger.valueOf(v).multiply(BigInteger.valueOf(X));
            BigInteger B = BigInteger.valueOf(100);
            double key = A.doubleValue() / B.doubleValue();

            if (M.containsKey(key)) {
                Voice voice = M.get(key);
                M.replace(key, new Voice(voice.A, voice.B, voice.n + 1));
            } else {
                M.put(key, new Voice(A, B, 1));
            }

            // A와 B 계산 로직
            A = BigInteger.valueOf(v).multiply(BigInteger.valueOf(2000000 - X * 10000));
            B = BigInteger.valueOf(1000000 - 1);
//            System.out.println(A + " " + B);

            key = A.doubleValue() / B.doubleValue();
//            System.out.println("key" + key);

            if (M.containsKey(key)) {
                Voice voice = M.get(key);
                M.replace(key, new Voice(voice.A, voice.B, voice.n - 1));
            } else {
                M.put(key, new Voice(A, B, -1));
            }
        }

        BigInteger resultA = BigInteger.ZERO;
        BigInteger resultB = BigInteger.ZERO;
        for (Voice voice : M.values()) {

//            System.out.println(voice.A + " " + voice.B + " " + voice.n);
            cnt += voice.n;
//            System.out.println(cnt);
            if (cnt >= K) {
                resultA = voice.A;
                resultB = voice.B;
                break;
            }
        }

        if (!resultA.equals(BigInteger.ZERO) && !resultB.equals(BigInteger.ZERO)) {
            BigInteger g = gcd(resultA, resultB);
            resultA = resultA.divide(g);
            resultB = resultB.divide(g);
            if (resultB.equals(BigInteger.ONE)) {
                result = resultA.toString();
            } else {
                result = resultA.toString() + "/" + resultB.toString();
            }
        }
        System.out.println(result);
    }

    public static BigInteger gcd(BigInteger A, BigInteger B) {
        while (!B.equals(BigInteger.ZERO)) {
            BigInteger temp = B;
            B = A.mod(B);
            A = temp;
        }
        return A;
    }
}
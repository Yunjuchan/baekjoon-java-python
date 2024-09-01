import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static class Voice {
        long A;
        long B;
        int n;

        public Voice (long A, long B, int n) {
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

        for (int i=0; i<N; i++) {
            long v = Long.parseLong(st.nextToken());
            long A = v * X;
            long B = 100;
            double key = (double) A / (double) B;

            if (M.containsKey(key)) {
                Voice voice = M.get(key);
                M.replace(key, new Voice(voice.A, voice.B, voice.n + 1));
            } else {
                M.put(key, new Voice(A, B, 1));
            }

            A = v * (2000000 - X * 10000);
            B = 1000000-1;

            key = (double) A / (double) B;
            if (M.containsKey(key)) {
                Voice voice = M.get(key);
                M.replace(key, new Voice(voice.A, voice.B, voice.n-1));
            } else {
                M.put(key, new Voice(A, B, -1));
            }
        }
        long resultA = 0;
        long resultB = 0;
        for (Voice voice : M.values()) {
            cnt += voice.n;
            if (cnt >= K) {
                resultA = voice.A;
                resultB = voice.B;
                break;
            }
        }

        if (resultA != 0 && resultB != 0) {
            long g = gcd(resultA, resultB);
            resultA /= g;
            resultB /= g;
            if (resultB == 1) {
                result = Long.toString(resultA);
            } else {
                result = Long.toString(resultA) + "/" + Long.toString(resultB);;
            }
        }
        System.out.println(result);
    }
    public static long gcd(long A, long B) {
        if (A < B) {
            long tmp = A;
            A = B;
            B = tmp;
        }
        while (B !=0) {
            long tmp = B;
            B = A % B;
            A = tmp;
        }
        return A;
    }
}
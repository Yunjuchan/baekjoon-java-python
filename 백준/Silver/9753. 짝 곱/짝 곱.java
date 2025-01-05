import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[100001];
        List<Integer> primes = new ArrayList<>();

        for (int i=2; i<=Math.sqrt(100000); i++) {
            for (int j=2; i*j<=100000; j++) {
                if (isNotPrime[i*j]) {
                    continue;
                }
                isNotPrime[i*j] = true;
            }
        }

        for (int i=2; i<=100000; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        int N = primes.size();

        for (int t=0; t<T; t++) {
            int result = Integer.MAX_VALUE;
            int K = Integer.parseInt(br.readLine());
            boolean flag = false;
            for (int i=0; i<N; i++) {
                if (flag) {
                    break;
                }
                if (primes.get(i) > Math.sqrt(K)) {
                    flag = true;
                }
                for (int j=i+1; j<N; j++) {
                    int tmp = primes.get(i) * primes.get(j);
                    if (tmp >= K) {
                        result = Math.min(result, tmp);
                        break;
                    }
                }
            }
            System.out.println(result);
        }

    }
}
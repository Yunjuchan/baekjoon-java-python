import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[1_000_001];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 2 * i; j <= 1_000_000; j += i) {
                isNotPrime[j] = true;
            }
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 1_000_000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            primes.add(i);
            set.add(i);
        }

        List<Integer> superPrimes = new ArrayList<>();

        for (int idx = 0; idx < primes.size(); idx++) {
            if (!set.contains(idx + 1)) {
                continue;
            }

            superPrimes.add(primes.get(idx));
        }

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine()) - 1;
            sb.append(superPrimes.get(N)).append("\n");
        }

        System.out.println(sb);
    }
}
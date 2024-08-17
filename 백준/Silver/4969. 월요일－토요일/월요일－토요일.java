import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> msp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] isNotPrime = new boolean[300001];

        // 월요일-토요일 소수 필터링
        for (int i = 2; i <= 300000; i++) {
            if (isNotPrime[i] || (i % 7 != 1 && i % 7 != 6)) {
                continue;
            }
            msp.add(i);
            for (int j = 2; j * i <= 300000; j++) {
                isNotPrime[j * i] = true;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 1) {
                break;
            }

            TreeSet<Integer> factors = new TreeSet<>(); // 최종 결과를 담을 TreeSet
            findAllCombinations(N, new TreeSet<>(), factors, 0);

            // 출력 형식 맞추기
            System.out.print(N + ":");
            for (int factor : factors) {
                System.out.print(" " + factor);
            }
            System.out.println();
        }
    }

    static void findAllCombinations(int N, TreeSet<Integer> currentFactors, TreeSet<Integer> result, int start) {
        if (N == 1) {
            // 현재 조합을 result에 추가
            result.addAll(currentFactors);
            return;
        }

        for (int i = start; i < msp.size(); i++) {
            int prime = msp.get(i);
            if (prime > N) break;
            if (N % prime == 0) {
                currentFactors.add(prime);
                findAllCombinations(N / prime, currentFactors, result, i);
                currentFactors.remove(prime); // 백트래킹
            }
        }
    }
}
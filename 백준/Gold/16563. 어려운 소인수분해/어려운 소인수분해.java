//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static StringBuilder sb = new StringBuilder();
//
//    public static void factorization(int k) {
//        for (int i = 2; i <= Math.sqrt(k); i++) {
//            while (k % i == 0) {
//                sb.append(i).append(" ");
//                k /= i;
//            }
//        }
//        if (k != 1) {
//            sb.append(k).append(" ");
//        }
//        sb.append("\n");
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            int k = Integer.parseInt(st.nextToken());
//            factorization(k);
//        }
//        System.out.println(sb);
//    }
//}
//
//


import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 5_000_000;
    static int[] smallestPrime = new int[5_000_001];
    static StringBuilder sb = new StringBuilder();

    public static void sieve() {
        for (int i = 2; i <= MAX; i++) {
            if (smallestPrime[i] != 0) {
                continue;
            }

            for (int j = i; j <= MAX; j += i) {
                if (smallestPrime[j] == 0) {
                    smallestPrime[j] = i;
                }
            }
        }
    }

    public static void factorization(int n) {
        while (n > 1) {
            sb.append(smallestPrime[n]).append(" ");
            n /= smallestPrime[n];
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sieve();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            factorization(k);
        }

        System.out.println(sb);
    }
}
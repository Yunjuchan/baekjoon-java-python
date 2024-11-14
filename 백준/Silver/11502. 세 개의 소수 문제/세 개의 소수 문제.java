import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static boolean flag = false;

    public static int[] result;
    public static List<Integer> isPrime = new ArrayList<>();
    public static void dfs(int level, int K, int[] arr) {
        if (level == 3) {
            if (K == 0) {
                flag = true;
                result = arr.clone();
            }
            return;
        }
        for (int x : isPrime) {
            if (x > K) {
                return;
            } else {
                arr[2-level] = x;
                dfs(level+1, K-x, arr);
                arr[2-level] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[1001];

        for (int i=2; i<1000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            isPrime.add(i);
            for (int j=2; i*j<=1000; j++) {
                isNotPrime[i*j] = true;
            }
        }
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            dfs(0, K, new int[3]);
            if (flag) {
                System.out.println(result[0] + " " + result[1] + " " + result[2]);
            } else {
                System.out.println(0);
            }
        }
    }
}
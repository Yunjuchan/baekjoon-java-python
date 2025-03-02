import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = Integer.MIN_VALUE;
        int resultB = 0;
        int resultE = 0;

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            int b = i;
            int e = N - i - 1;
            int tmp = arr1[i] * arr2[i];
            dp[b][e] = tmp;
            if (result < tmp) {
                result = tmp;
                resultB = b;
                resultE = e;
            }
            for (int j = 1; j <= Math.min(b, e); j++) {
                tmp += arr1[i - j] * arr2[i + j] + arr1[i + j] * arr2[i - j];
                dp[b - j][e - j] = tmp;
                if (result < tmp) {
                    result = tmp;
                    resultB = b - j;
                    resultE = e - j;
                }
            }
        }

        for (int i = 0; i < N - 1; i++) {
            int tmp = arr1[i] * arr2[i + 1] + arr1[i + 1] * arr2[i];
            int b = i;
            int e = N - i - 2;
            dp[b][e] = tmp;

            if (result < tmp) {
                result = tmp;
                resultB = b;
                resultE = e;
            }
            for (int j = 1; j <= Math.min(b, e); j++) {
                tmp += arr1[i - j] * arr2[i + j + 1] + arr1[i + j + 1] * arr2[i - j];
                dp[b - j][e - j] = tmp;
                if (result < tmp) {
                    result = tmp;
                    resultB = b - j;
                    resultE = e - j;
                }
            }
        }
        
        System.out.println(resultB + " " + resultE);
        System.out.println(result);
    }
}
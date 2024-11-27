import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sum[i+1] = sum[i] + arr[i];
        }

        int result = 0;
        for (int i=1; i<=N; i++) {
            for (int j=0; j<=i; j++) {
                if (sum[i] - sum[j] == M) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
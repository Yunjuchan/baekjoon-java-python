import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    static int[][] atk;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] power = new long[N];
        Arrays.fill(power, Integer.MAX_VALUE);
        power[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                power[j] = Math.min(power[j], Math.max((long) (j - i) * (1 + Math.abs(A[i] - A[j])), power[i]));
            }
        }
        System.out.println(power[N - 1]);
    }
}

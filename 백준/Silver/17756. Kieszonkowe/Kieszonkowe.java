import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] % 2 == 1) {
                hasOdd = true;
                min = Math.min(min, arr[i]);
            }
        }

        if (sum % 2 == 0) {
            System.out.println(sum);
        } else {
            if (N == 1 || !hasOdd) {
                System.out.println("NIESTETY");
            } else {
                System.out.println(sum - min);
            }
        }
    }
}
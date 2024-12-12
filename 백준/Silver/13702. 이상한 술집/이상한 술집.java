import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int s = 1;
        int e = 1;

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[i]);
        }
        int result = 0;

        if (N == 1) {
            System.out.println(arr[0] / K);
            return;
        }
        while (s < e) {
            int mid = (s + e) / 2;
            int cnt = 0;
            for (int i=0; i<N; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= K) {
                result = mid;
                s = mid+1;
            } else {
                e = mid;
            }
        }

        System.out.println(result);
    }
}
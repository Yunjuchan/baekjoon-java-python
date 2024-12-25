import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int S = 1;
        int E = arr[N-1];
        int result = -1;
        while (S <= E) {
            int mid = (S + E) / 2;

            int cnt = 1;
            int prev = arr[0];
            for (int i=1; i<N; i++) {
                if (arr[i] >= prev + mid) {
                    cnt++;
                    prev = arr[i];
                }
            }

            if (cnt < C) {
                E = mid-1;
            } else {
                S = mid+1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
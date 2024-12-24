import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int s = 0;
        int e = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e, arr[i]);
        }
        long deposit = Long.parseLong(br.readLine());

        int Max = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            long tmp = 0;
            for (int i=0; i<N; i++) {
                tmp += Math.min(arr[i], mid);
            }
            if (tmp > deposit) {
                e = mid-1;
            } else {
                s = mid+1;
                Max = mid;
            }
        }
        
        System.out.println(Max);
    }
}

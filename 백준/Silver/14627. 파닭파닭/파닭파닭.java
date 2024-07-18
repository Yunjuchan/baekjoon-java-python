import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> A = new ArrayList<>();
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long s = 0;
        long e = 0;
        long sum = 0;
        for (int i=0; i<S; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            e = Math.max(e, L);
            sum += L;
            A.add(L);
        }
        long length = 0;
        while (s<=e) {
            long mid = (s+e+1) / 2;
            if (mid == 0) {
                break;
            }
            long count = 0;
            for (int a : A) {
                count += a / mid;
            }
            if (count >= C) {
                length = mid;
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        System.out.println((sum - C * length));
    }
}
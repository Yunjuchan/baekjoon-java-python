import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        long s = 0;
        long e = M;
        long result = e;

        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = check(mid, M, A);

            if (cnt >= K) { 
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long check(long mid, long M, int[] A) {
        int N = A.length;
        long count = 0;
        long sum = 0;
        int i = 0;
        
        for (int j = 0; j < N; j++) {
            sum += A[j] + mid;
            
            while (sum >= M && i <= j) {
                count += (N - j);
                sum -= A[i] + mid;
                i++;
            }
        }

        return count;
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int result = Integer.MAX_VALUE;

        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                int tmp = Math.abs(i) + Math.abs(j);
                int diff = (arr[1] + j) - (arr[0] + i);
                boolean isValid = true;

                int prev = arr[1] + j;
                for (int k=2; k<N; k++) {
                    int expected = prev + diff;
                    if (Math.abs(expected - arr[k]) > 1) {
                        isValid = false;
                        break;
                    }
                    if (expected != arr[k]) {
                        tmp++;
                    }
                    prev = expected;
                }

                if (isValid) {
                    result = Math.min(result, tmp);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
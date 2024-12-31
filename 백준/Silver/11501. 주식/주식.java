import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long Max = 0;
            long cnt = 0;
            long result = 0;
            long tmp = 0;
            for (int i=N-1; i>=0; i--) {
                if (Max < arr[i]) {
                    result += Max * cnt + tmp;
                    Max = arr[i];
                    cnt = 0;
                    tmp = 0;
                } else {
                    cnt++;
                    tmp -= arr[i];
                }
            }
            result += cnt * Max + tmp;
            System.out.println(result);
        }
    }
}
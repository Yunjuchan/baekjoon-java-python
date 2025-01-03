import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i=0; i<X; i++) {
            sum += arr[i];
        }

        int result = sum;
        int cnt = 1;

        for (int i=0; i<N-X; i++) {
            sum -= arr[i];
            sum += arr[i+X];
            if (sum > result) {
                result = sum;
                cnt = 1;
            } else if (sum == result) {
                cnt++;
            }
        }

        if (sum == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(result);
        System.out.println(cnt);
    }

}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        long total = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        if (N == 1) {
            if (arr[0] > 1) {
                System.out.println("Unhappy");    
            } else {
                System.out.println("Happy");
            }
            return;
        }

        boolean flag = false;
        for (int i=0; i<N; i++) {
            if (arr[i] > total / 2) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Unhappy");
        } else {
            System.out.println("Happy");
        }
    }
}

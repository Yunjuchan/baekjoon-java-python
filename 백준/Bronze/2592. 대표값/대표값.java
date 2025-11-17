import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int cnt = 0;
        int mode = 0;
        int[] arr = new int[1000];
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            arr[N] += 1;
            sum += N;
        }

        for (int i = 10; i < 1000; i += 10) {
            if (arr[i] > cnt) {
                cnt = arr[i];
                mode = i;
            }
        }
        System.out.println(sum / 10);
        System.out.println(mode);
    }
}
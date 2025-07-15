import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];
        int[] count = new int[47];
        int idx = 1;
        int num = 1;
        int res = 1;
        while (idx <= 1000) {
            arr[idx] = num;
            idx++;
            res--;
            if (res == 0) {
                num += 1;
                res = num;
            }
        }


        for (int i = 1; i <= 1000; i++) {
            arr[i] += arr[i - 1];
        }
        int answer = arr[B] - arr[A - 1];
        System.out.println(answer);
    }
}
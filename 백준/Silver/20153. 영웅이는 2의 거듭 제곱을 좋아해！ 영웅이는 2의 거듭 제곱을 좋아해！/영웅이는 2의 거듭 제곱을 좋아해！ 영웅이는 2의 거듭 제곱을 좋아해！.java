import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[22];
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            arr[i] = A;
            int j = 0;
            while (A != 0) {
                count[j] += A % 2;
                A /= 2;
                j++;
            }
        }

        int answer = 0;
        for (int i = 0; i < 22; i++) {
            if (count[i] % 2 == 0) {
                continue;
            }
            answer += (int) Math.pow(2, i);
        }

        for (int i = 0; i < N; i++) {
            int cur = 0;
            int A = arr[i];
            for (int j = 0; j < 22; j++) {

                if ((count[j] - A % 2) % 2 == 0) {
                    A /= 2;
                    continue;
                }

                A /= 2;
                cur += (int) Math.pow(2, j);
            }
            answer = Math.max(answer, cur);
        }

        System.out.println(answer + "" + answer);

    }
}
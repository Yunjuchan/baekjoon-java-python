import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n;
            max = Math.max(max, n);
        }

        if (max < (sum + 1) / 2) {
            System.out.println(sum);
        } else {
            System.out.println((sum - max) * 2 - 1);
        }
    }
}
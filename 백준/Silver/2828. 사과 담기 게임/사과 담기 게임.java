import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int left = 1;
        int right = M;

        int J = Integer.parseInt(br.readLine());

        for (int i = 0; i < J; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target < left) {
                int diff = left - target;
                left -= diff;
                right -= diff;
                answer += diff;
            } else if (target > right) {
                int diff = target - right;
                left += diff;
                right += diff;
                answer += diff;
            }
        }

        System.out.println(answer);
    }
}
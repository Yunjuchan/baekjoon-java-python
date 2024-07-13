import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            long tmp = 0;
            long result = Long.MIN_VALUE;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int profit = Integer.parseInt(st.nextToken());
                tmp = Long.max(profit, tmp+profit);
                if (result < tmp) {
                    result = tmp;
                }
            }
            System.out.println(result);
        }

    }
}
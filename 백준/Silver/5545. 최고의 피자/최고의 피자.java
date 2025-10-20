import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        double cal = C;
        double price = A;

        int[] top = new int[N];

        for (int i = 0; i < N; i++) {
            top[i] = - Integer.parseInt(br.readLine());
        }

        Arrays.sort(top);

        for (int i = 0; i < N; i++) {
            double nextCal = cal - top[i];
            double nextPrice = price + B;

            if (cal / price > nextCal / nextPrice) {
                break;
            } else {
                cal = nextCal;
                price = nextPrice;
            }
        }

        System.out.println((int) (cal / price));
    }
}

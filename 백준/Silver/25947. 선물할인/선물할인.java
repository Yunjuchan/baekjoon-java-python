import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        boolean flag = a == 0;
        int[] price = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(price);

        int[] half = new int[N];
        long[] Sum = new long[N+1];
        long[] halfSum = new long[N+1];
        half[0] = price[0] / 2;

        for (int i=1; i<=N; i++) {
            Sum[i] = Sum[i-1] + price[i-1];
            half[i-1] = price[i-1] / 2;
            halfSum[i] = halfSum[i-1] + half[i-1];
        }

        int cnt = 0;
        long use = 0;

        for (int i=1; i<=N; i++) {
            if (Sum[i] > b) {
                use = Sum[i-1];
                cnt = i-1;
                break;
            }
            use = Sum[i];
            cnt = i;
        }

        int idx = -1;

        if (cnt >= a) {
            idx = cnt - a;
            a = 0;
            use -= halfSum[cnt] - halfSum[idx];
        } else {
            idx = 0;
            a -= cnt;
            use = halfSum[cnt];
        }

        while (cnt < N) {
            if (a != 0) {
                a--;
                use += half[cnt];
                cnt++;
            } else {
                if (flag) {
                    use += price[cnt];
                } else {
                    use += half[cnt] + half[idx];
                }
                cnt++;
                idx++;
            }

            if (use > b) {
                cnt--;
                break;
            }
        }
        System.out.println(cnt);
    }
}
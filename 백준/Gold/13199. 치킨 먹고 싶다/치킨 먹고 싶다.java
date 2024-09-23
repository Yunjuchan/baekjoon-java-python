import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int coupon = M / P * C;
            coupon += coupon / F * (C-F);
            int vip = 0;
            if (coupon >= F) {
                vip = (coupon - F) / (F-C) + 1;
            }
            sb.append(vip).append("\n");
        }
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double[][] days = new double[N + 1][2];
        double[][] prob = new double[2][2];
        int P = Integer.parseInt(st.nextToken());

        days[0][P] = 1000;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            double p = Double.parseDouble(st.nextToken());
            prob[i / 2][i % 2] = p;
        }

        for (int i = 1; i <= N; i++) {
            days[i][0] = days[i - 1][0] * prob[0][0] + days[i - 1][1] * prob[1][0];
            days[i][1] = days[i - 1][1] * prob[1][1] + days[i - 1][0] * prob[0][1];
        }
        
        System.out.println(Math.round(days[N][0]));
        System.out.println(Math.round(days[N][1]));

    }
}
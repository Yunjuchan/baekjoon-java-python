import java.io.*;
import java.util.*;


public class Main {
    static int m1 = 1, m2;
    static double u1 = 0, u2;
    public static double[] changeV (int m1, int m2, double u1, double u2) {
        double[] nextV = new double[2];
        nextV[0] = ((m1 - m2) * u1 + 2 * m2 * u2) / (m1 + m2);
        nextV[1] = (2 * m1 * u1 - (m1 - m2) * u2) / (m1 + m2);
        return nextV;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m2 = Integer.parseInt(st.nextToken());
        m2 = m2 * m2;
        u2 = 100;
        int cnt = 1;
        double[] nextV = changeV(m1, m2, u1, u2);
        u1 = nextV[0];
        u2 = nextV[1];
        while (true) {
            if (u1 > 0) {
                u1 = -u1;
                cnt++;
            } else {
                if (u1 > u2) {
                    break;
                }
                nextV = changeV(m1, m2, u1, u2);
                u1 = nextV[0];
                u2 = nextV[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
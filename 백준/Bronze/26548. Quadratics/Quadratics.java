import java.io.*;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double D = Math.sqrt(b * b - 4 * a * c);
            double x = (-b + D) / (2 * a);
            double y = (-b - D) / (2 * a);
            System.out.printf("%.3f, %.3f\n", x, y);
        }
    }
}
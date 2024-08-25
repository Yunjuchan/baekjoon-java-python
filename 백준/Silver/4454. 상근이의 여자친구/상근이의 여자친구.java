import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            double t = Double.parseDouble(st.nextToken());

            double low = 0.0;
            double high = 1000.0;

            while (high - low > 1e-7) {
                double mid = (low + high) / 2;
                double fuelConsumption = a * Math.pow(mid, 4) + b * Math.pow(mid, 3) + c * Math.pow(mid, 2) + d * mid;

                if (fuelConsumption * (m / mid) <= t) {
                    low = mid;
                } else {
                    high = mid;
                }
            }

            double truncated = Math.floor(low * 100) / 100;
            System.out.printf("%.2f%n", truncated);
        }
    }
}
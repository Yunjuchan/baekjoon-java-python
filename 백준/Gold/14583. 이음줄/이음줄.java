import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double h = Double.parseDouble(st.nextToken());
        double v = Double.parseDouble(st.nextToken());
        double l = Math.sqrt(h * h + v * v);
        double a = h * (l - h) / v;
        double x = Math.sqrt(h * h + a * a);
        double area = h * v - a * h;
        double y = area / x;
        x /= 2;

        System.out.printf("%.2f %.2f\n", x, y);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double d1 = Integer.parseInt(br.readLine());
        double d2 = Integer.parseInt(br.readLine());

        double area = 0;
        area += d1 * 2;
        area += d2 * Math.PI * 2;

        System.out.printf("%.6f\n", area);
    }
}
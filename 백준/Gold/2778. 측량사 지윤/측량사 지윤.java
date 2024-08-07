import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            double[][] lines = new double[3][3];
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                lines[i][0] = Double.parseDouble(st.nextToken());
                lines[i][1] = Double.parseDouble(st.nextToken());
                lines[i][2] = Double.parseDouble(st.nextToken());
            }

            double[][] points = new double[3][2];
            boolean valid = true;

            for (int i = 0; i < 3; i++) {
                int j = (i + 1) % 3;
                double[] point = intersect(lines[i], lines[j]);
                if (point == null) {
                    valid = false;
                    break;
                }
                points[i] = point;
            }

            if (valid) {
                double area = calculateTriangleArea(points);
                System.out.printf("%.4f\n", area);
            } else {
                System.out.println("0.0000");
            }
        }
    }

    public static double[] intersect(double[] line1, double[] line2) {
        double a1 = line1[0], b1 = line1[1], c1 = line1[2];
        double a2 = line2[0], b2 = line2[1], c2 = line2[2];

        double determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return null;
        }

        double x = (b1 * c2 - b2 * c1) / determinant;
        double y = (a2 * c1 - a1 * c2) / determinant;
        return new double[]{x, y};
    }

    public static double calculateTriangleArea(double[][] points) {
        double x1 = points[0][0], y1 = points[0][1];
        double x2 = points[1][0], y2 = points[1][1];
        double x3 = points[2][0], y3 = points[2][1];

        double area = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        return area;
    }
}
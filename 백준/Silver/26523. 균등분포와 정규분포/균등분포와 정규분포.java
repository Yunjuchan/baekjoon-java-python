import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] A;
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }

        int lineCount = lines.size();


        for (int i = 0; i < 100; i++) {
            A = new double[lineCount/100];
            for (int j = 0; j < lineCount/100; j++) {
                A[j] = Double.parseDouble(lines.get(i*lineCount/100+j));
            }

            double avg = Arrays.stream(A).average().orElse(0.0);
            double variance = calculateVariance(A, avg, lineCount / 100);

            double x = Math.abs(variance - 1.0 / 12);
            double y = Math.abs(variance - 0.05);
            if (x < y) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

    private static double calculateVariance(double[] A, double avg, int lineCount) {
        double sumOfSquaredDifferences = Arrays.stream(A)
                .map(x -> Math.pow(x - avg, 2))
                .sum();
        return sumOfSquaredDifferences / lineCount;
    }
}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Integer.parseInt(br.readLine());
        System.out.printf("%.6f\n", Math.PI * R * R);
        System.out.printf("%.6f\n", 2 * R * R);
    }
}
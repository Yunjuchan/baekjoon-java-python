import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            double a = Double.parseDouble(br.readLine());
            double x = a / 6;
            System.out.printf("%.10f\n", x);
        }
    }
}
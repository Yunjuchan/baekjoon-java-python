import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 0;
        while (true) {
            t++;
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                return;
            }
            double w = Integer.parseInt(st.nextToken());
            double l = Integer.parseInt(st.nextToken());
            double x = Math.sqrt(w*w + l*l);
            if (x <= 2 * r) {
                System.out.println("Pizza " + t + " fits on the table.");
            } else {
                System.out.println("Pizza " + t + " does not fit on the table.");
            }
        }

    }
}
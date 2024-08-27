import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            double h = Integer.parseInt(st.nextToken());
            double w = Integer.parseInt(st.nextToken());
            double bmi = 10000 * w / Math.pow(h, 2);
            if (h <= 140) {
                System.out.println(6);
            } else if ( h < 146) {
                System.out.println(5);
            } else if ( h < 159) {
                System.out.println(4);
            } else if ( h < 161) {
                if (bmi >= 16.0 && bmi < 35.0) {
                    System.out.println(3);
                } else {
                    System.out.println(4);
                }
            } else if ( h < 204) {
                if (bmi >= 20 && bmi < 25.0) {
                    System.out.println(1);
                } else if (bmi >= 18.5 && bmi < 30.0) {
                    System.out.println(2);
                } else if (bmi >= 16.0 && bmi < 35.0) {
                    System.out.println(3);
                } else {
                    System.out.println(4);
                }
            } else {
                System.out.println(4);
            }
        }
    }
}
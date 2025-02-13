import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[][] arr = new double[N][2];
        double s = 0, e = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    s = arr[i][0];
                } else if (i == N - 1) {
                    e = arr[i][0];
                }
            }
        }
        double radian = 0;
        for (int i = 1; i < N - 1; i++) {
            if (arr[i - 1][1] < arr[i][1]) {
                radian = Math.max(radian, Math.atan(arr[i][1] / (arr[i][0] - s)));
            }

            if (arr[i + 1][1] < arr[i][1]) {
                radian = Math.max(radian, Math.atan(arr[i][1] / (e - arr[i][0])));
            }
        }

        double degree = Math.toDegrees(radian);
        if (degree % 1 == 0.0) {
            System.out.println((int) degree);
        } else {
            System.out.printf("%.7f\n", degree);
        }


    }
}

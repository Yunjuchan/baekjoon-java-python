import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = C / A + 1;  // C / A를 기준으로 적당히 큰 값으로 설정

        while (right - left > 1e-9) {  // 수렴 조건
            double mid = (left + right) / 2;
            double value = A * mid + B * Math.sin(mid);

            if (value > C) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println((left + right) / 2);
    }
}
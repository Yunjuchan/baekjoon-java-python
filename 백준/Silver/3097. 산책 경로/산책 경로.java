import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        List<int[]> lines = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            x += a;
            y += b;
            lines.add(new int[]{a, b});
        }
        double result = Double.MAX_VALUE;

        for (int i=0; i<N; i++) {
            int dx = lines.get(i)[0];
            int dy = lines.get(i)[1];
            result = Math.min(result, Math.sqrt(Math.pow(x-dx, 2) + Math.pow(y-dy, 2)));
        }
        System.out.println(x + " " + y);
        System.out.printf("%.2f", result);
    }
}
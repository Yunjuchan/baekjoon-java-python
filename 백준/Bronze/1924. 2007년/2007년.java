import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] arr = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            d += days[i];
        }

        System.out.println(arr[d % 7]);
    }
}

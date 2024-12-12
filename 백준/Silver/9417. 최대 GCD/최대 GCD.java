import java.io.*;
import java.util.*;

public class Main {

    public static int gcd(int x, int y) {
        if (x < y) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            int result = 0;
            List<Integer> arr = new ArrayList<>();

            for (String num : br.readLine().split(" ")) {
                int n = Integer.parseInt(num);
                arr.add(n);
            }
            int N = arr.size();
            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                    result = Math.max(result, gcd(arr.get(i), arr.get(j)));
                }
            }

            System.out.println(result);

        }

    }
}
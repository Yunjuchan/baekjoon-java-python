import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Double, Integer> Plus = new HashMap<>();
        Map<Double, Integer> Minus = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int up = 0;
        int down = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            double k = y / x;
            if (x > 0) {
                if (!Plus.containsKey(k)) {
                    Plus.put(k, 1);
                } else {
                    Plus.replace(k, Plus.get(k) + 1);
                }
            } else if (x < 0) {
                if (!Minus.containsKey(k)) {
                    Minus.put(k, 1);
                } else {
                    Minus.replace(k, Minus.get(k) + 1);
                }
            } else if (x == 0.0 && y > 0) {
                up++;
            } else {
                down++;
            }
        }

        int result = 0;
        result = Math.max(result, up);
        result = Math.max(result, down);
        for (double k : Minus.keySet()) {
            if (result < Minus.get(k)) {
                result = Minus.get(k);
            }
        }

        for (double k : Plus.keySet()) {
            if (result < Plus.get(k)) {
                result = Plus.get(k);
            }
        }

//        System.out.println(up + " " + down);

        System.out.println(result);

    }
}
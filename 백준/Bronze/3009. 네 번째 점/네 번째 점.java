import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> X = new HashSet<>();
        Set<Integer> Y = new HashSet<>();
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (X.contains(x)) {
                X.remove(x);
            } else {
                X.add(x);
            }

            if (Y.contains(y)) {
                Y.remove(y);
            } else {
                Y.add(y);
            }
        }

        List<Integer> resX = new ArrayList<>(X);
        List<Integer> resY = new ArrayList<>(Y);
        System.out.println(resX.get(0) + " " + resY.get(0));
    }
}
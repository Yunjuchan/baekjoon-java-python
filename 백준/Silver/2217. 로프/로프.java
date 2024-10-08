import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int result = 0;

        List<Integer> lope = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            lope.add(Integer.parseInt(st.nextToken()));
        }

        lope.sort(Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            result = Math.max(result, lope.get(i) * (i+1));
        }
        System.out.println(result);
    }
}
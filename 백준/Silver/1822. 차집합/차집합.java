import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long NA = Integer.parseInt(st.nextToken());
        long NB = Integer.parseInt(st.nextToken());

        List<Integer> R = new ArrayList<>();

        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<NA; i++) {
            int x = Integer.parseInt(st.nextToken());
            A.add(x);
        }

        Set<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<NB; i++) {
            int x = Integer.parseInt(st.nextToken());
            B.add(x);
        }

        for (int a : A) {
            if (!B.contains(a)) {
                R.add(a);
            }
        }
        R.sort((a, b) -> (a - b));

        System.out.println(R.size());
        for (int r : R) {
            System.out.print(r + " ");
        }
    }
}
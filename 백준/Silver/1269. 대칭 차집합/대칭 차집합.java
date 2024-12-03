import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<NA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<NB; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        System.out.println(set.size());
    }
}
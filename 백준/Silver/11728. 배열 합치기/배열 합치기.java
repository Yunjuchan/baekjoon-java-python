import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<NA; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<NB; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort((a, b) -> a-b);

        for (int x : arr) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }
}
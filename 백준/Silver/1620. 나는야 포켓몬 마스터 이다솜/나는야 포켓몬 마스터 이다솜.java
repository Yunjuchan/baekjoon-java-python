import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> D = new HashMap<>();
        Map<String, Integer> D2 = new HashMap<>();
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            String poke = st.nextToken();
            D.put(i, poke);
            D2.put(poke, i);
        }
        for (int j=0; j<M; j++) {
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();
            if (Character.isDigit(q.charAt(0))) {
                System.out.println(D.get(Integer.parseInt(q)));
            } else {
                System.out.println(D2.get(q));
            }
        }
    }
}
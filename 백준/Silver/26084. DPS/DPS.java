import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String teamName = st.nextToken();
        Map<Character, Integer> M = new HashMap<>();
        Map<Character, Integer> M2 = new HashMap<>();
        for (int i=0; i<3; i++) {
            char c = teamName.charAt(i);
            if (M.containsKey(c)) {
                M.replace(c, M.get(c)+1);
            } else {
                M.put(c, 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            String name = new StringTokenizer(br.readLine()).nextToken();
            char first = name.charAt(0);
            if (M2.containsKey(first)) {
                M2.replace(first, M2.get(first)+1);
            } else {
                M2.put(first, 1);
            }
        }

        long result = 1;
        for (char c: M.keySet()) {
            int n = M.get(c);
            if (!M2.containsKey(c)) {
                result = 0;
                break;
            }
            for (int i=0; i<n; i++) {
                result *= (M2.get(c)-i);
            }

            for (int i=0; i<n; i++) {
                result /= (n-i);
            }
        }
        System.out.println(result);
    }
}
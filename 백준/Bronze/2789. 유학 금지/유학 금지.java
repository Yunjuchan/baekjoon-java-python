import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String no = "CAMBRIDGE";
        Set<Character> s = new HashSet<>();
        for (char c : no.toCharArray()) {
            s.add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (!s.contains(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }
}
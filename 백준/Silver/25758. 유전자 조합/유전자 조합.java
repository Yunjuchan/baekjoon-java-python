import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Character> first = new TreeSet<>();
        Set<Character> second = new TreeSet<>();
        Set<Character> expression = new TreeSet<>();
        for (int i=0; i<N; i++) {
            String dna = st.nextToken();
            char x = dna.charAt(0);
            char y = dna.charAt(1);
            for (char c : second) {
                expression.add(x > c ? x : c);
            }
            for (char c : first) {
                expression.add(y > c ? y : c);
            }
            first.add(x);
            second.add(y);
        }
        System.out.println(expression.size());
        for (char c : expression) {
            System.out.print(c + " ");
        }
    }
}
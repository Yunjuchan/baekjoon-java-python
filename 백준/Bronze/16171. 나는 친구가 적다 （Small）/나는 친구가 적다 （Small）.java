import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = br.readLine();
        String target = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ((int) c >= 48 && (int) c <= 57) {
                continue;
            }
            sb.append(c);
        }
        if (sb.toString().contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
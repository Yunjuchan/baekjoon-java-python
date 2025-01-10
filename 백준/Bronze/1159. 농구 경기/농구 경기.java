import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for (int i=97; i<=122; i++) {
            map.put((char) i, 0);
        }
        for (int i=0; i<N; i++) {
            char c = br.readLine().charAt(0);
            map.replace(c, map.get(c)+1);
        }
        String result = "";
        for (char c : map.keySet()) {
            if (map.get(c) >= 5) {
                result += c;
            }
        }
        if (result.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result);
        }
    }
}
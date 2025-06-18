import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine().substring(0, 5);
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String target = br.readLine().substring(0, 5);
            if (code.equals(target)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
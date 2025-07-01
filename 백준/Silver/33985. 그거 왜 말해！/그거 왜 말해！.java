import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String T = br.readLine();
        
        if (T.charAt(0) == 'B' || T.charAt(N - 1) == 'A') {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }
}
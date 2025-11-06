import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        if (c == 'N' || c == 'n') {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }
    }
}

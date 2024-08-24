import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.readLine().length();
        int b = br.readLine().length();

        if (a < b) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}
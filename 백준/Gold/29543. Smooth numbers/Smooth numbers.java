import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int result = 0;
        switch (l) {
            case 1 : result = 9; break;
            case 2 : result = 99; break;
            case 3 : result = 989; break;
            case 4 : result = 9889; break;
            case 5 : result = 97679; break;
            case 6 : result = 976679; break;
            case 7 : result = 9643469; break;
            case 8 : result = 96433469; break;
            default : result = -1; break;
        }
        System.out.println(result);
    }
}
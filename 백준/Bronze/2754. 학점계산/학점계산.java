import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();
        if (grade.length() == 1) {
            System.out.println(0.0);
            return;
        }
        double score = 'E' - grade.charAt(0);
        if (grade.charAt(1) == '+') {
            score += 0.3;
        } else if (grade.charAt(1) == '-') {
            score -= 0.3;
        }
        
        System.out.println(score);
    }
}
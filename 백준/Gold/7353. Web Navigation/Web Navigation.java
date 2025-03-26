import java.io.*;
import java.util.*;

public class Main {
    static Stack<String> forward, back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        forward = new Stack<>();
        back = new Stack<>();
        String cur = "http://www.acm.org/";

        while (true) {
            String query = sc.next();

            if (query.equals("QUIT")){
                break;
            } else if (query.equals("VISIT")) {
                forward = new Stack<>();
                back.push(cur);
                cur = sc.next();
                System.out.println(cur);
            } else if (query.equals("BACK")) {
                if (back.isEmpty()) {
                    System.out.println("Ignored");
                } else {
                    forward.push(cur);
                    cur = back.pop();
                    System.out.println(cur);
                }
            } else if (query.equals("FORWARD")) {
                if (forward.isEmpty()) {
                    System.out.println("Ignored");
                } else {
                    back.push(cur);
                    cur = forward.pop();
                    System.out.println(cur);
                }
            }
        }
    }
}

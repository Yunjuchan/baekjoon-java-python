import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        String result = "";

        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;

        if (!A.equals("Fizz") && !A.equals("Buzz") && !A.equals("FizzBuzz")) {
            a = Integer.parseInt(A);
            d = a + 3;
        } else if (!B.equals("Fizz") && !B.equals("Buzz") && !B.equals("FizzBuzz")) {
            b = Integer.parseInt(B);
            d = b + 2;
        } else if (!C.equals("Fizz") && !C.equals("Buzz") && !C.equals("FizzBuzz")) {
            c = Integer.parseInt(C);
            d = c + 1;
        }

        if (d % 3 == 0 && d % 5 == 0) {
            result = "FizzBuzz";
        } else if (d % 3 == 0) {
            result = "Fizz";
        } else if (d % 5 == 0) {
            result = "Buzz";
        } else {
            result = "" + d;
        }

        System.out.println(result);
    }
}
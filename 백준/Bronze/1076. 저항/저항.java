import java.io.*;

public class Main {
    public static long resist(String color) {
        if (color.equals("black")) {
            return 0;
        } else if (color.equals("brown")) {
            return 1;
        } else if (color.equals("red")) {
            return 2;
        } else if (color.equals("orange")) {
            return 3;
        } else if (color.equals("yellow")) {
            return 4;
        } else if (color.equals("green")) {
            return 5;
        } else if (color.equals("blue")) {
            return 6;
        } else if (color.equals("violet")) {
            return 7;
        } else if (color.equals("grey")) {
            return 8;
        } else {
            return 9;
        }
    }

    public static long pow(String color) {
        if (color.equals("black")) {
            return 1;
        } else if (color.equals("brown")) {
            return 10;
        } else if (color.equals("red")) {
            return 100;
        } else if (color.equals("orange")) {
            return 1_000;
        } else if (color.equals("yellow")) {
            return 10_000;
        } else if (color.equals("green")) {
            return 100_000;
        } else if (color.equals("blue")) {
            return 1_000_000;
        } else if (color.equals("violet")) {
            return 10_000_000;
        } else if (color.equals("grey")) {
            return 100_000_000;
        } else {
            return 1_000_000_000L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;
        for (int i = 0; i < 2; i++) {
            answer *= 10;
            String color = br.readLine();
            answer += resist(color);
        }
        String color = br.readLine();
        answer *= pow(color);

        System.out.println(answer);
    }
}
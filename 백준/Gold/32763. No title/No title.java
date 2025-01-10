import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] arr = new boolean[N+1];
        arr[1] = true;

        boolean plus = false;
        for (int i=1; i<N; i++) {
            System.out.println("? " + i + " * " + (i+1));
            System.out.flush();
            char response = sc.next().charAt(0);
            if (response == '+') {
                arr[i+1] = arr[i];
            } else {
                arr[i+1] = !arr[i];
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=i+1; j<=N; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("? " + i + " + " + j);
                    System.out.flush();
                    char response = sc.next().charAt(0);
                    if (response == '+') {
                        plus = arr[i];
                    } else {
                        plus = !arr[i];
                    }

                    System.out.print("!");
                    for (int k=1; k<=N; k++) {
                        if (arr[k] == plus) {
                            System.out.print(" +");
                        } else {
                            System.out.print(" -");
                        }
                    }
                    System.out.println();
                    System.out.flush();
                    return;
                }
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] N = new int[3];
        for (int i=0; i<3; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> arr = new ArrayList<>();
        for (int i=0; i<3; i++) {
            arr.add(new int[N[i]]);
        }

        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N[i]; j++) {
                arr.get(i)[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr.get(i));
        }


        int result = Integer.MAX_VALUE;
        for (int i=0; i<N[0]; i++) {
            for (int j=0; j<N[1]; j++) {
                int a = arr.get(0)[i];
                int b = arr.get(1)[j];

                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                int low = arr.get(2)[0];
                boolean between = false;
                int high = arr.get(2)[arr.get(2).length-1];

                int s = 0;
                int e = N[2]-1;
                while (s <= e) {
                    int mid = (s+e) / 2;
                    if (arr.get(2)[mid] < a) {
                        low = arr.get(2)[mid];
                        s = mid+1;
                    } else {
                        e = mid-1;
                    }
                }

                s = 0;
                e = N[2]-1;
                while (s <= e) {
                    int mid = (s+e) / 2;
                    if (arr.get(2)[mid] < a) {
                        s = mid+1;
                    } else if (arr.get(2)[mid] > b){
                        e = mid-1;
                    } else {
                        between = true;
                        break;
                    }
                }

                s = 0;
                e = N[2] - 1;
                while (s <= e) {
                    int mid = (s+e) / 2;
                    if (arr.get(2)[mid] > b) {
                        high = arr.get(2)[mid];
                        e = mid-1;
                    } else {
                        s = mid+1;
                    }
                }
//                System.out.println("a: " + a + " b: " + b);
//                System.out.println("low: " + low + " between: " + between + " high: " + high);
                if (low < a) {
                    result = Math.min(result, b - low);
                }
                if (between) {
                    result = Math.min(result, b-a);
                }
                if (high > b) {
                    result = Math.min(result, high - a);
                }
            }
        }
        System.out.println(result);
    }
}
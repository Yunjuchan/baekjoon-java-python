import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] now = new boolean[N];
        boolean[] target = new boolean[N];

        String state = br.readLine();
        for (int i = 0; i < N; i++) {
            now[i] = state.charAt(i) == '1';
        }

        state = br.readLine();
        for (int i = 0; i < N; i++) {
            target[i] = state.charAt(i) == '1';
        }
        
        int result1 = calculateSwitches(N, now.clone(), target, false);
        
        int result2 = calculateSwitches(N, now.clone(), target, true);
        
        int answer = -1;
        if (result1 != -1 && result2 != -1) {
            answer = Math.min(result1, result2);
        } else if (result1 != -1) {
            answer = result1;
        } else if (result2 != -1) {
            answer = result2;
        }

        System.out.println(answer);
    }

    public static int calculateSwitches(int N, boolean[] now, boolean[] target, boolean firstSwitch) {
        int count = 0;

        if (firstSwitch) {
            toggle(now, 0);
            count++;
        }

        for (int i = 1; i < N; i++) {
            if (now[i - 1] != target[i - 1]) {
                toggle(now, i);
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (now[i] != target[i]) {
                return -1;
            }
        }

        return count;
    }

    public static void toggle(boolean[] arr, int index) {
        arr[index] = !arr[index];
        if (index > 0) {
            arr[index - 1] = !arr[index - 1];
        }
        if (index < arr.length - 1) {
            arr[index + 1] = !arr[index + 1];
        }
    }
}
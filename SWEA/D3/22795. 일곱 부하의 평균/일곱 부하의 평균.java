import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			int Sum = 0;
            int Max = 0;
            for (int i=0; i<6; i++) {
                int now = sc.nextInt();
                Sum += now;
                
                if (Max < now) {
                    Max = now;
                }
            }
            
            int res = Sum % 7;
            int result = Max - Max % 7 - res + 7;
            if (result <= Max) {
                result += 7;
            }
			System.out.println(result);
		}
	}
}
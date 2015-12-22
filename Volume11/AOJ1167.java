import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1167 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int[] dp = new int[1000000];
		Arrays.fill(dp,Integer.MAX_VALUE/2);
		dp[0] = 0;

		int[] odd = new int[1000000];
		Arrays.fill(odd,Integer.MAX_VALUE/2);
		odd[0] = 0;


		for (int i=1; i<1000000; i++) {
			for (int j=1; j<=i; j++) {
				int v = j*(j+1)*(j+2)/6;
				if (i < v) break;
				dp[i] = Math.min(dp[i], dp[i-v] + 1);

				if (v%2 == 0) continue;
				if (i < v) break;
				odd[i] = Math.min(odd[i], odd[i-v] + 1);
			}
		}

		while (true) {
			int q = in.nextInt();
			if (q == 0) break;
			out.println(dp[q]+" "+odd[q]);
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0042 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int cnt = 1;
		while (true) {
			int w = in.nextInt();
			if(w == 0) return;
			int n = in.nextInt();

			int[] value = new int[n];
			int[] weight = new int[n];

			for (int i=0; i<n; i++) {
				String[] s = in.next().split(",");
				value[i] = Integer.parseInt(s[0]);
				weight[i] = Integer.parseInt(s[1]);
			}

			int[][] dp = new int[n+1][w+1];

			for (int i=0; i<n; i++) {
				for (int j=0; j<=w; j++) {
					if (j + weight[i] <= w) {
						dp[i+1][j+weight[i]] = Math.max(dp[i+1][j], dp[i][j] + value[i]);
					}
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
				}
			}

			out.println("Case "+(cnt++)+":");

			int ans1 = -1, ans2 = -1;
			for (int i=0; i<=w; i++) {
				if (ans1 < dp[n][i]) {
					ans1 = dp[n][i];
					ans2 = i;
				}
			}

			out.println(ans1);
			out.println(ans2);
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0098 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int n = in.nextInt();
		int[][] a = new int[n+2][n+2];
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				a[i][j] += in.nextInt();
				a[i+1][j] += a[i][j];
				a[i][j+1] += a[i][j];
				a[i+1][j+1] -= a[i][j];
			}
		}


		int[][] dp = new int[n+2][n+2];

		for (int i=0; i<=n+1; i++) {
			dp[i][0] = Integer.MIN_VALUE;
			dp[0][i] = Integer.MIN_VALUE;
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

				for (int k=i-1; k>=0; k--) {
					for (int l=j-1; l>=0; l--) {
						dp[i][j] = Math.max(dp[i][j], a[i][j] - a[k][j] - a[i][l] + a[k][l]);
					}
				}
			}
		}

		out.println(dp[n][n]);
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
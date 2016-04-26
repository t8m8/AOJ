import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0097 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int s = in.nextInt();
		if (n + s == 0) return false;

		out.println(rec(n,-1,s));

		return true;
	}

	static long[][][] dp = new long[10][101][1001];

	static long rec(int n, int x, int s) {
		if (n == 0 && s == 0) return 1;
		if (n == 0) return 0;
		if (x != -1 && dp[n][x][s] != -1) return dp[n][x][s];
		long res = 0;
		for (int i=x+1; i<=100; i++) {
			if (s-i >= 0) {
				res += rec(n-1, i, s-i);
			}
		}

		if (x == -1) return res;
		return dp[n][x][s] = res;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		for (int i=0; i<10; i++) {
			for (int j=0; j<101; j++) {
				Arrays.fill(dp[i][j],-1);
			}
		}

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
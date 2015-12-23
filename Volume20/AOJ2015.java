import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2015 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[] h = new int[n];
		int[] w = new int[m];
		for (int i=0; i<n; i++) {
			h[i] = in.nextInt();
		}
		for (int i=0; i<m; i++) {
			w[i] = in.nextInt();
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {

			}
		}

		int[][] dp = new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {

			}
		}


		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
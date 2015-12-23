import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0102 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[][] a = new int[n+1][n+1];
		for (int i=0; i<n; i++) {
			int sum = 0;
			for (int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				sum += a[i][j];
			}
			a[i][n] = sum;
		}

		int s = 0;

		for (int j=0; j<n; j++) {
			int sum = 0;
			for (int i=0; i<n; i++) {
				sum += a[i][j];
			}
			a[n][j] = sum;
			s += sum;
		}

		a[n][n] = s;

		for (int i=0; i<=n; i++) {
			for (int j=0; j<=n; j++) {
				out.printf("%5d",a[i][j]);
			}
			out.println();
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
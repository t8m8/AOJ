import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0078 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[][] table = new int[n][n];

		int cx = n/2, cy = n/2+1;

		int cnt = 0;
		while (cnt < n*n) {
			if (table[cy][cx] == 0) {
				table[cy][cx] = ++cnt;
				cx = (cx+1)%n;
				cy = (cy+1)%n;
			} else {
				cx = (cx+n-1)%n;
				cy = (cy+1)%n;
			}
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				out.printf("%4d",table[i][j]);
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2001 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		if (n + m + a == 0) return false;
		a--;

		int[][] e = new int[m][3];

		for (int i=0; i<m; i++) {
			for (int j=0; j<3; j++) {
				e[i][j] = in.nextInt() - 1;
			}
		}

		Arrays.sort(e, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});

		int[] p = new int[n];
		for (int i=0; i<n; i++) {
			p[i] = i;
		}

		for (int i=0; i<m; i++) {
			int t = p[e[i][1]];
			p[e[i][1]] = p[e[i][2]];
			p[e[i][2]] = t;
		}

		for (int i=0; i<n; i++) {
			if (p[i] == a) {
				out.println((i+1));
			}
		}

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0202 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean[] eratosthenes(int m) {
		int n = m + 1;
		boolean[] isp = new boolean[n];
		if (n < 2) return isp;

		Arrays.fill(isp, true);

		for (int i=2; i*i<n; i++) {
			if (!isp[i]) continue;
			for (int j=i+i; j<n; j+=i) {
				isp[j] = false;
			}
		}

		return isp;
	}

	static boolean solve() {
		int n = in.nextInt();
		int x = in.nextInt();
		if (n + x == 0) return false;

		int[] v = new int[n];
		for (int i=0; i<n; i++) {
			v[i] = in.nextInt();
		}

		boolean[] f = new boolean[x+1];
		f[0] = true;
		for (int i=0; i<x+1; i++) {
			if (!f[i]) continue;
			for (int j=0; j<n; j++) {
				if (i + v[j] <= x)
					f[i+v[j]] = true;
			}
		}

		boolean[] p = eratosthenes(x+1);
		for (int i=x; i>=2; i--) {
			if (f[i] && p[i]) {
				out.println(i);
				return true;
			}
		}

		out.println("NA");

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
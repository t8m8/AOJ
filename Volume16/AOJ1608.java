import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1608 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int ans = 1<<30;
		for (int i=0; i<n-1; i++) {
			ans = Math.min(ans, a[i+1] - a[i]);
		}
		out.println(ans);

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
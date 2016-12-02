import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1285 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int w = in.nextInt();
		if (n + w == 0) return false;

		int[] v = new int[n];
		int[] c = new int[120];
		for (int i=0; i<n; i++) {
			v[i] = in.nextInt();
			c[v[i]/w]++;
		}

		double max = 0, idx = 0;
		for (int i=0; i<120; i++) {
			if (c[i] > 0) idx = i;
			max = Math.max(max, c[i]);
		}

		double ans = 0;
		for (int i=0; i<120; i++) {
			ans += c[i]/max*(1-i/idx);
		}
		out.printf("%.6f\n", ans+0.01);

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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2706 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int gcd(int a, int b) {
		if (a == 0) return b;
		return gcd(b%a, a);
	}

	static void solve() {
		int p = in.nextInt();
		int q = in.nextInt();
		p = q / gcd(p, q);
		long ans = 1;
		for (int i=2; i*i<=p; i++) {
			if (p%i == 0) {
				ans *= i;
				while (p%i == 0) p /= i;
			}
		}
		if (p != 1) ans *= p;
		out.println(ans);
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}
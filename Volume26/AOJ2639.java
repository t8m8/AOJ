import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2639 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		int pos = 0, ans = 0;

		for (int i=0; i<200; i++) {
			if (i%2 == 0) {

				if (pos + a >= 60 && pos <= c) {
					out.println((ans + (c - pos)));
					return;
				} else if (pos + a >= 60 && c <= (pos + a)%60) {
					out.println((ans + (60 - pos) + c));
					return;
				} else if (pos <= c && c <= pos + a) {
					out.println((ans + (c - pos)));
					return;
				}

				pos = (pos + a)%60;
				ans += a;

			} else {
				pos = (pos + b)%60;
				ans += b;
			}
		}

		out.println("-1");
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0205 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int t = in.nextInt();
		if (t == 0) return false;

		int[] h = new int[5];
		boolean[] f = new boolean[4];
		h[0] = t;
		f[t] = true;
		for (int i=1; i<5; i++) {
			h[i] = in.nextInt();
			f[h[i]] = true;
		}

		int cnt = 0;
		for (int i=1; i<=3; i++) {
			if (f[i]) cnt++;
		}

		if (cnt == 3 || cnt == 1) {
			for (int i=0; i<5; i++) {
				out.println("3");
			}
		} else {
			if (f[1] && f[2]) {
				for (int i=0; i<5; i++) {
					out.println(h[i] == 1 ? "1" : "2");
				}
			} else if (f[2] && f[3]) {
				for (int i=0; i<5; i++) {
					out.println(h[i] == 2 ? "1" : "2");
				}
			} else if (f[3] && f[1]){
				for (int i=0; i<5; i++) {
					out.println(h[i] == 3 ? "1" : "2");
				}
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
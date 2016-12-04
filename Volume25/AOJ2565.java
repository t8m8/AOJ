import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2565 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		String[] s = new String[n];

		for (int i=0; i<n; i++) {
			s[i] = in.next();
		}

		long min = -(1L<<60), max = 1L<<60;

		for (int i=0; i<n; i++) {
			if (s[i].charAt(0) == 'x') {
				if (i != n-1 && s[i+1].charAt(0) == 'x') {
					min = 1L<<60;
					max = -min;
					break;
				}

				if (i%2 == 0) {
					if (i != 0)
						max = Math.min(max, Integer.parseInt(s[i-1])-1);
					if (i != n-1)
						max = Math.min(max, Integer.parseInt(s[i+1])-1);
				} else {
						min = Math.max(min, Integer.parseInt(s[i-1])+1);
					if (i != n-1)
						min = Math.max(min, Integer.parseInt(s[i+1])+1);
				}
			} else {
				int x = Integer.parseInt(s[i]);
				if (i%2 == 0) {
					if (i != 0 && s[i-1].charAt(0) != 'x' && Integer.parseInt(s[i-1]) < x) {
						min = 1L<<60;
						max = -min;
						break;
					}
					if (i != n-1 && s[i+1].charAt(0) != 'x' && Integer.parseInt(s[i+1]) < x) {
						min = 1L<<60;
						max = -min;
						break;
					}
				} else {
					if (i != 0 && s[i-1].charAt(0) != 'x' && Integer.parseInt(s[i-1]) > x) {
						min = 1L<<60;
						max = -min;
						break;
					}
					if (i != n-1 && s[i+1].charAt(0) != 'x' && Integer.parseInt(s[i+1]) > x) {
						min = 1L<<60;
						max = -min;
						break;
					}
				}
			}
		}

		if (min == max) {
			out.println(max);
		} else if (min > max) {
			out.println("none");
		} else {
			out.println("ambiguous");
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
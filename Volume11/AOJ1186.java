import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1186 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int h = in.nextInt();
		int w = in.nextInt();
		if (h + w == 0) return false;

		int d = h*h + w*w;
		int min = 1<<30;
		int ansh = 1<<30, answ = 1<<30;

		for (int i=1; i<200; i++) {
			for (int j=i+1; j<200; j++) {
				if (d < i*i + j*j || (d == i*i + j*j && h < i))
				if (min > i*i + j*j || (min == i*i + j*j && ansh > i)) {
					min = i*i + j*j;
					ansh = i;
					answ = j;
				}
			}
		}

		out.println(ansh+" "+answ);

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
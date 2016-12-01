import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2198 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		String[] names = new String[n];
		double[][] a = new double[n][2];
		for (int i=0; i<n; i++) {
			names[i] = in.next();
			int p = in.nextInt();
			int t1 = in.nextInt();
			int t2 = in.nextInt();
			int t3 = in.nextInt();
			int t4 = in.nextInt();
			int t5 = in.nextInt();
			int f = in.nextInt();
			int s = in.nextInt();
			int m = in.nextInt();
			int v = f*s*m;

			a[i][0] = i;
			a[i][1] = (double)(v - p)/(t1 + t2 + t3 + (t4 + t5)*m);
		}

		Arrays.sort(a, new Comparator<double[]>(){
			public int compare(double[] a, double[] b) {
				if (a[1] != b[1]) return Double.compare(b[1], a[1]);
				return names[(int)a[0]].compareTo(names[(int)b[0]]);
			}
		});

		for (int i=0; i<n; i++) {
			out.println(names[(int)a[i][0]]);
		}
		out.println("#");

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
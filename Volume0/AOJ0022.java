import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0022 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		while(true) {
			int n = in.nextInt();
			if (n == 0) break;
			int[] a = new int[n];

			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
			}

			out.println(requireMaxSubarray(a));
		}
	}

	public static int requireMaxSubarray(int[] a) {
		int n = a.length;
		int res = a[0], max = a[0];
		for (int i=1; i<n; i++) {
			max = Math.max(a[i], max+a[i]);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
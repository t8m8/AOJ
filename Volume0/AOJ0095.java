import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0095 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int n = in.nextInt();
		int ma = -1, max = -1;

		for (int i=0; i<n; i++) {
			int a = in.nextInt();
			int v = in.nextInt();

			if (max < v) {
				ma = a;
				max = v;
			} else if (max == v && a < ma) {
				ma = a;
			}
		}

		out.println(ma + " " + max);
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
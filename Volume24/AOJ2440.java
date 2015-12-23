import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2440 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int n = in.nextInt();
		HashSet<String> ids = new HashSet<String>();
		for (int i=0; i<n; i++) {
			ids.add(in.next());
		}

		int m = in.nextInt();
		boolean f = true;
		for (int i=0; i<m; i++) {
			String u = in.next();
			if (ids.contains(u)) {
				if (f) {
					out.println("Opened by "+u);
					f = !f;
				} else {
					out.println("Closed by "+u);
					f = !f;
				}
			} else {
				out.println("Unknown "+u);
			}
		}
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
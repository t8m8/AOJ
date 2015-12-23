import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2582 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		boolean f = false;
		boolean[] foot = new boolean[2];
		int cnt = 0;
		for (int i=0; i<n; i++) {
			String s = in.next();
			if ("lu".equals(s)) {
				foot[0] = true;
				if (foot[0] && foot[1] && !f) {
					cnt++;
					f = !f;
				}
			} else if ("ru".equals(s)) {
				foot[1] = true;
				if (foot[0] && foot[1] && !f) {
					cnt++;
					f = !f;
				}
			} else if ("ld".equals(s)) {
				foot[0] = false;
				if (!foot[0] && !foot[1] && f) {
					cnt++;
					f = !f;
				}
			} else {
				foot[1] = false;
				if (!foot[0] && !foot[1] && f) {
					cnt++;
					f = !f;
				}
			}
		}

		out.println(cnt);

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0033 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static String solve() {

		int a = 0, b = 0;

		int[] x = new int[10];

		for (int i=0; i<10; i++) {
			x[i] = in.nextInt();
		}

		for (int i=0; i<10; i++) {
			if (x[i] < a && x[i] < b) return "NO";
			if (a < x[i] && b < x[i]) {
				if (a > b) a = x[i];
				else b = x[i];
			} else if (a < x[i]) {
				a = x[i];
			} else {
				b = x[i];
			}
		}

		return "YES";
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int n = in.nextInt();

		while (n-- > 0) out.println(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
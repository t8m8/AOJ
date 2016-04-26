import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0016 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		double r = Math.toRadians(90);
		double x = 0, y = 0;
		while (true) {
			String[] str = in.next().split(",");
			if (str[0].charAt(0) == '0' && str[1].charAt(0) == '0') break;

			int d = Integer.parseInt(str[0]);

			x += d*Math.cos(r);
			y += d*Math.sin(r);

			r -= Math.toRadians(Double.parseDouble(str[1]));
		}

		out.println(x >= 0 ? (int)x : (int)Math.ceil(x));
		out.println(y >= 0 ? (int)y : (int)Math.ceil(y));
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0024 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		double v = in.nextDouble();
		double t = v/9.8;
		double y = 4.9*t*t;

		for (int i=1; ; i++) {
			if (y <= 5*i-5) {
				out.println(i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext())solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0045 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int cnt = 0;
		double sum = 0, sumc = 0;
		while (in.hasNext()) {
			cnt++;
			String[] s = in.next().split(",");
			sumc += Double.parseDouble(s[1]);
			sum += Double.parseDouble(s[0])*Double.parseDouble(s[1]);
		}
		out.println((int)sum);
		out.println((int)Math.round(sumc/cnt));
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0014 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		while (in.hasNext()) {
			int d = in.nextInt();
			int ans = 0;
			for (int i=d; i<600; i+=d) {
				ans += i*i*d;
			}
			out.println(ans);
			out.flush();
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
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0054 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();

		int ans = 0;

		for (int i=0; i<n; i++) {
			a %= b;
			a *= 10;
			ans += a/b;
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
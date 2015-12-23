import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2149 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int x = in.nextInt();
		if (n + a + b + c + x == 0) return false;

		int f = 0;
		boolean flag = false;
		for (int i=0; i<n; i++) {
			int y = in.nextInt();
			if (i == 0 && x == y) continue;
			while (!flag) {
				x = (a*x+b)%c;
				f++;
				if (x == y) break;
				if (f >= 10000) {
					out.println("-1");
					flag = true;
				}
			}
		}

		if (flag) return true;

		out.println(f);
		out.flush();

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
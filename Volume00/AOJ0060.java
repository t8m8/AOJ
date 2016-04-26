import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0060 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		boolean[] f = new boolean[11];
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		f[a] = f[b] = f[c] = true;

		int x = a + b;
		double cnt = 0;
		for (int i=1; i<11; i++) {
			if (!f[i] && x + i <= 20) {
				cnt++;
			}
		}

		out.println(cnt/7 >= 0.5 ? "YES" : "NO");
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
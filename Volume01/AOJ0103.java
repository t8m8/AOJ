import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0103 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int cnt = 0, ocnt = 0;
		int[] a = new int[3];
		while (ocnt < 3) {
			String s = in.next();
			if ("HIT".equals(s)) {
				if (a[2] == 1) cnt++;
				a[2] = a[1];
				a[1] = a[0];
				a[0] = 1;
			} else if ("HOMERUN".equals(s)) {
				int t = 0;
				for (int i=0; i<3; i++) {
					t += a[i];
				}
				cnt += t + 1;
				a = new int[3];
			} else {
				ocnt++;
			}
		}
		out.println(cnt);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int n = in.nextInt();
		while(n-- > 0) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
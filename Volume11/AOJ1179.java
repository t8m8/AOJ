import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1179 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int y = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();

		int cnt = 0;
		for (int i=y+1; i<1000; i++) {
			for (int j=1; j<=10; j++) {
				for (int k=1; k<=(j%2 == 1 || i%3 == 0 ? 20 : 19); k++) {
					cnt++;
				}
			}
		}

		for (int j=m+1; j<=10; j++) {
			for (int k=1; k<=(j%2 == 1 || y%3 == 0 ? 20 : 19); k++) {
				cnt++;
			}
		}

		for (int k=d; k<=(m%2 == 1 || y%3 == 0 ? 20 : 19); k++) {
			cnt++;
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
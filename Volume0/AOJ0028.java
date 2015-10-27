import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0028 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int max = 0;
		int[] cnt = new int[200];
		while (in.hasNext()) {
			max = Math.max(++cnt[in.nextInt()], max);
		}
		for (int i=0; i<101; i++) {
			if (cnt[i] == max) out.println(i);
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
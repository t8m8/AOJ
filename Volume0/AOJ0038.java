import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0038 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		String[] s = in.next().split(",");
		int[] a = new int[5];
		for (int i=0; i<5; i++) {
			a[i] = Integer.parseInt(s[i]);
		}

		Arrays.sort(a);
		if ((a[0] == a[1] && a[1] == a[2] && a[2] == a[3]) || (a[1] == a[2] && a[2] == a[3] && a[3] == a[4])) {
			out.println("four card");
		} else if ((a[0] == a[1] && a[1] == a[2] && a[3] == a[4]) || (a[0] == a[1] && a[2] == a[3] && a[3] == a[4])) {
			out.println("full house");
		} else if ((a[0] + 1 == a[1] && a[1] + 1 == a[2] && a[2] + 1 == a[3] && a[3] + 1 == a[4]) || (a[0] == 1 && a[1] == 10 && a[2] == 11 && a[3] == 12 && a[4] == 13)) {
			out.println("straight");
		} else if ((a[0] == a[1] && a[1] == a[2]) || (a[2] == a[3] && a[3] == a[4]) || (a[1] == a[2] && a[2] == a[3])) {
			out.println("three card");
		} else if ((a[0] == a[1] && a[2] == a[3]) || (a[0] == a[1] && a[3] == a[4]) || (a[1] == a[2] && a[3] == a[4])) {
			out.println("two pair");
		} else if (a[0] == a[1] || a[1] == a[2] || a[2] == a[3] || a[3] == a[4]) {
			out.println("one pair");
		} else {
			out.println("null");
		}
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
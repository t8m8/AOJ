import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0052 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int cnt = 0;
		while (n != 0) {
			cnt += n/5;
			n /= 5;
		}
		out.println(cnt);
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
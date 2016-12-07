import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0208 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[] num = {0, 1, 2, 3, 5, 7, 8, 9};

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		StringBuilder ans = new StringBuilder();
		while (n != 0){
			ans.append(num[n%8]);
			n /= 8;
		}
		ans.reverse();
		out.println(ans);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}
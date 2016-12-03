import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1346 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		String s = in.next();
		int n = in.nextInt();
		int ans1 = s.charAt(0) - '0';
		for (int i=1; i<s.length(); i+=2) {
			if (s.charAt(i) == '+') {
				ans1 += s.charAt(i+1) - '0';
			} else {
				ans1 *= s.charAt(i+1) - '0';
			}
		}
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.add(s.charAt(0) - '0');
		for (int i=1; i<s.length(); i+=2) {
			if (s.charAt(i) == '+') {
				stack.add(s.charAt(i+1) - '0');
			} else {
				stack.add(stack.pollLast()*(s.charAt(i+1) - '0'));
			}
		}
		int ans2 = 0;
		while (stack.size() > 0) ans2 += stack.poll();

		if (ans1 == n) {
			if (ans2 == n) out.println("U");
			else out.println("L");
		} else {
			if (ans2 == n) out.println("M");
			else out.println("I");
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}
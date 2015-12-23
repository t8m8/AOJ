import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2252 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static HashSet<Character> right = new HashSet<Character>();

	static boolean solve() {
		String s = in.next();
		if ("#".equals(s)) return false;

		boolean f = right.contains(s.charAt(0));

		int cnt = 0;
		for (int i=1; i<s.length(); i++) {
			if ((f && !right.contains(s.charAt(i))) || (!f && right.contains(s.charAt(i)))) {
				cnt++;
				f = !f;
			}
		}

		out.println(cnt);

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		right.add('y');
		right.add('u');
		right.add('i');
		right.add('o');
		right.add('p');
		right.add('h');
		right.add('j');
		right.add('k');
		right.add('l');
		right.add('n');
		right.add('m');

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
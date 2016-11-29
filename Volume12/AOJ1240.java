import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1240 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		while (n-- > 0) {
			String order = in.next();
			StringBuilder m = new StringBuilder(in.next());
			int ln = m.length();
			for (int i=order.length()-1; i>=0; i--) {
				switch (order.charAt(i)) {
					case 'J':
						m.insert(0, m.charAt(ln-1));
						m.deleteCharAt(ln);
						break;
					case 'C':
						m.append(m.charAt(0));
						m.deleteCharAt(0);
						break;
					case 'E':
						if (ln%2 == 0) {
							m.append(m.substring(0, ln/2));
							m.delete(0, ln/2);
						} else {
							m.append(m.charAt(ln/2));
							m.append(m.substring(0, ln/2));
							m.delete(0, (ln+1)/2);
						}
						break;
					case 'A':
						m.reverse();
						break;
					case 'P':
						for (int j=0; j<ln; j++) {
							if ('1' <= m.charAt(j) && m.charAt(j) <= '9') {
								m.setCharAt(j, (char)(m.charAt(j)-1));
							} else if (m.charAt(j) == '0') {
								m.setCharAt(j, '9');
							}
						}
						break;
					case 'M':
						for (int j=0; j<ln; j++) {
							if ('0' <= m.charAt(j) && m.charAt(j) <= '8') {
								m.setCharAt(j, (char)(m.charAt(j)+1));
							} else if (m.charAt(j) == '9') {
								m.setCharAt(j, '0');
							}
						}
						break;
				}
				// out.println(m);
			}

			out.println(m);
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
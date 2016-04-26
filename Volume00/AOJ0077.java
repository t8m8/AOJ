import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0077 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		String s = in.next();
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '@') {
				int c = s.charAt(i+1) - '0';
				for (int j=0; j<c; j++) {
					sb.append(s.charAt(i+2));
				}
				i += 2;
			} else {
				sb.append(s.charAt(i));
			}
		}

		out.println(sb);
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
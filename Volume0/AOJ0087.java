import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0087 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		String str;
		while ((str = br.readLine()) != null) {
			ArrayDeque<Double> stack = new ArrayDeque<Double>();
			String[] s = str.split(" ");
			for (int i=0; i<s.length; i++) {
				if ("+".equals(s[i])) {
					double x = stack.pollLast();
					double y = stack.pollLast();
					stack.addLast(x+y);
				} else if ("-".equals(s[i])) {
					double x = stack.pollLast();
					double y = stack.pollLast();
					stack.addLast(y-x);
				} else if ("*".equals(s[i])) {
					double x = stack.pollLast();
					double y = stack.pollLast();
					stack.addLast(x*y);
				} else if ("/".equals(s[i])) {
					double x = stack.pollLast();
					double y = stack.pollLast();
					stack.addLast(y/x);
				} else {
					stack.addLast(Double.parseDouble(s[i]));
				}
			}

			out.println(stack.pollLast());
		}
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		br.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
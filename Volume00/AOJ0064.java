import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0064 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		String s = "";
		while(in.hasNext()) s += in.next()+" ";

		int ans = 0;
		for (int i=s.length()-1; i>=0; i--) {
			int d = 1, t = 0;
			while (i>=0 && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
				t += (s.charAt(i)-'0')*d;
				d *= 10;
				i--;
			}
			ans += t;
		}

		out.println(ans);
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
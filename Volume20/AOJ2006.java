import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2006 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static char[][] c =
	{
		{'.',',','!','?',' '}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
		{'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}
	};

	static void solve() {
		String s = in.next();
		int pos = 0;
		String ans = "";
		while (pos < s.length()) {
			int id = s.charAt(pos) - '0' - 1;
			if (id == -1) {
				pos++;
				continue;
			}
			int cnt = 0;
			while (s.charAt(pos) != '0') {
				pos++;
				cnt = (cnt + 1)%c[id].length;
			}

			ans += c[id][(cnt + c[id].length - 1)%c[id].length];
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = in.nextInt();
		while(n-- > 0) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0063 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		String s = in.next();
		for (int i=0; i<s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int cnt = 0;

		while(in.hasNext()) if (solve()) cnt++;
		out.println(cnt);
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
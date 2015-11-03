import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0066 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{

		String s = in.next();
		char[][] cs = new char[3][3];

		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				cs[i][j] = s.charAt(i*3+j);
			}
		}

		if (isOk(cs,'o')) {
			out.println('o');
		} else if (isOk(cs,'x')) {
			out.println('x');
		} else {
			out.println('d');
		}
	}

	static boolean isOk(char[][] cs, char c) {

		for (int i=0; i<3; i++) {
			boolean f1 = true;
			boolean f2 = true;
			for (int j=0; j<3; j++) {
				if (cs[i][j] != c) f1 = false;
				if (cs[j][i] != c) f2 = false;
			}
			if (f1) return true;
			if (f2) return true;
		}

		return (cs[0][0] == c && cs[0][0] == cs[1][1] && cs[1][1] == cs[2][2]) || (cs[0][2] == c && cs[0][2] == cs[1][1] && cs[1][1] == cs[2][0]);
	}

	public static void main(String[] args) throws Exception {
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
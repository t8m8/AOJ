import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0040 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{

		int n = Integer.parseInt(br.readLine());

		outer:
		while (n-- > 0) {
			String str = br.readLine();
			String[] s = str.split(" ");

			for (int a=1; a<26; a++) {
				if (gcd(a,26) != 1) continue;

				for (int b=0; b<26; b++) {
					for (int i=0; i<s.length; i++) {
						if (s[i].length() != 4) continue;
						if (isThat(s[i],a,b) || isThis(s[i],a,b)) {
							print(str,a,b);
							continue outer;
						}
					}
				}
			}

		}
	}

	static int gcd(int a, int b) {
		return a == 0 ? b : gcd(b%a, a);
	}

	static boolean isThat(String s, int a, int b) {
		if ((a*('t'-'a')+b)%26 + 'a' != s.charAt(0)) return false;
		if ((a*('h'-'a')+b)%26 + 'a' != s.charAt(1)) return false;
		if ((a*('a'-'a')+b)%26 + 'a' != s.charAt(2)) return false;
		if ((a*('t'-'a')+b)%26 + 'a' != s.charAt(3)) return false;
		return true;
	}

	static boolean isThis(String s, int a, int b) {
		if ((a*('t'-'a')+b)%26 + 'a' != s.charAt(0)) return false;
		if ((a*('h'-'a')+b)%26 + 'a' != s.charAt(1)) return false;
		if ((a*('i'-'a')+b)%26 + 'a' != s.charAt(2)) return false;
		if ((a*('s'-'a')+b)%26 + 'a' != s.charAt(3)) return false;
		return true;
	}

	static void print(String s, int a, int b) {
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == ' ') {
				out.print(' ');
			} else {
				int c = (s.charAt(i) - 'a' - b + 26)%26;
				while (c%a != 0) c += 26;
				out.print((char)(c/a + 'a'));
			}
		}
		out.println();
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
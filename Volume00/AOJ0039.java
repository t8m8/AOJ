import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0039 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static HashMap<Character, Integer> map = new HashMap<Character,Integer>();

	static void solve() {

		String s = in.next();
		int ans = 0;

		for (int i=0; i<s.length(); i++) {
			if (i == s.length()-1 || map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
				ans += map.get(s.charAt(i));
			} else {
				ans -= map.get(s.charAt(i));
			}
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);

		while (in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0029 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{

		String[] s = br.readLine().split(" ");
		int max = 0;
		String ans1 = "", ans2 = "";
		HashMap<String,Integer> map = new HashMap<String,Integer>();

		for (int i=0; i<s.length; i++) {

			if (map.containsKey(s[i])) {
				int c = map.get(s[i])+1;
				if (max < c) {
					ans1 = s[i];
					max = c;
				}
				map.put(s[i],c);
			} else {
				if (max < 1) {
					ans1 = s[i];
					max = 1;
				}
				map.put(s[i],1);
			}

			if (ans2.length() < s[i].length()) ans2 = s[i];
		}

		out.println(ans1 + " " + ans2);
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
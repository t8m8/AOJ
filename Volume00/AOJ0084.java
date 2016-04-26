import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0084 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		String[] s = br.readLine().split(" ");
		int n = s.length;
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<n; i++) {
			s[i] = s[i].replaceAll(",","").replaceAll("\\.","");
			if (2 < s[i].length() && s[i].length() < 7) {
				list.add(s[i]);
			}
		}

		for (int i=0; i<list.size()-1; i++) {
			out.print(list.get(i) + " ");
		}
		out.println(list.get(list.size()-1));
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
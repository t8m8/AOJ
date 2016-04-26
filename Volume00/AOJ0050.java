import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0050 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		out.println(br.readLine().replaceAll("apple","TEMP").replaceAll("peach","apple").replaceAll("TEMP","peach"));
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
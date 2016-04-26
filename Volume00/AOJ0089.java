import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;

public class AOJ0089 {

    static final Scanner in = new Scanner(System.in);
    static final PrintWriter out = new PrintWriter(System.out,false);

    static void solve() {
    	ptr = 0;
    	String[][] s = new String[101][];
        while (in.hasNext()) {
        	s[ptr] = in.next().split(",");
        	ptr++;
        }

        str = copyOf(s,ptr);
        dp = new int[ptr][1000];
        for (int i=0; i<ptr; i++) fill(dp[i],-1);
        out.println(rec(0,0));
    }

    static String[][] str;
    static int ptr;
    static int[][] dp;

    static int rec(int x, int depth) {
    	if (dp[depth][x] != -1) return dp[depth][x];
    	if (depth == ptr-1) return Integer.parseInt(str[depth][x]);
    	int max = -1;
    	if (depth < ptr/2) {
    		max = max(max,rec(x,depth+1));
    		max = max(max,rec(x+1,depth+1));
    	}else {
    		if (x != 0) max = max(max,rec(x-1,depth+1));
    		if (x < str[depth].length-1) max = max(max,rec(x,depth+1));
    	}
    	return dp[depth][x] = max + Integer.parseInt(str[depth][x]);
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
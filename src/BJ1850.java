import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수 = 유클리드 호제법
 * 16:01
 * https://www.acmicpc.net/problem/1850
 * @author YangGaNorm
 *
 */
public class BJ1850 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static long a, b, res;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		a = next();
		b = next();
		res = GCD(a, b);
		sb = new StringBuilder();
		while (res > 0) {
			sb.append(1);
			res--;
		}
		System.out.println(sb);

	}
	
	static long GCD(long _a, long _b)
	{
	    if(_b==0)return _a;
	    else return GCD(_b,_a%_b);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static long next() {
		return Long.parseLong(st.nextToken());
	}
}

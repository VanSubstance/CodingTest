import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 누적 계승
// 시간 오버

public class BJ27279 {
	static BufferedReader br;
	static StringTokenizer st;
	static Integer n, m, b[], dp[], tempSum;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		n = next();
		m = next();
		line();
		dp = new Integer[m + 1];
		Arrays.fill(dp,  0);
		for (int i = 0; i < n; i++) {
			dp[next()]++;
		}
		line();
		b = new Integer[m];
		for (int i = 0; i < m; i++) {
			b[i] = next();
		}
		Arrays.sort(b);
		for (int i = m; i > 0; i--) {
			dp[i] -= b[i - 1];
			if (dp[i] < 0) {
				System.out.println("NO");
				return;
			}
			dp[i - 1] += dp[i];
		}
		
		System.out.println("YES");
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int next() {
		return Integer.parseInt(st.nextToken());
	}
}

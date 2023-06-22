import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp
 * 42:51
 * @author YangGaNorm
 *
 */
public class BJ15989 {
	static BufferedReader br;
	static StringBuilder sb;
	static int t, n, dp[][];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		t = next();
		sb = new StringBuilder();
		dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		while (t > 0) {
			n = next();
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) + "\n");
			t--;
		}
		System.out.print(sb);
	}

	static int next() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

// 공약수 + 범위 한정
// 31: 29
public class BJ14232 {
	static BufferedReader br;
	static StringBuilder sb;
	static long n, temp, lim;
	static List<Long> cms;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		lim = ((long) Math.sqrt(n)) + 1L;
		cms = new ArrayList<>();
		temp = 2;
		while (n > 1) {
			if (temp>=lim) {
				cms.add(n);
				break;
			}
			if (n % temp != 0) {
				temp++;
				continue;
			}
			// 약수 식별
			n /= temp;
			cms.add(temp);
		}
		sb = new StringBuilder();
		sb.append(cms.size()).append("\n");
		for (int i = 0; i < cms.size(); i++) {
			sb.append(cms.get(i));
			if (i + 1 < cms.size()) {
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
}

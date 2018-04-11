import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String phone;
		String regex = "(.)*(\\d+)(.)*";
		while ((phone = in.readLine()) != null) {
			if(phone.matches(regex)) {
				String str = phone.replaceAll("\\D+","");
				if(str.charAt(0) == '0' && str.length() != 1) {
					System.out.println("62" + str.substring(1, str.length()));
				} else {
					System.out.println(str);
				}
			} else {
				System.out.println(phone);
			}
		}
	}

}

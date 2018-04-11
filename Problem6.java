import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String string1 = in.readLine();
		String string2 = in.readLine();
		String removedString = "";
		
		for(int i = 0 ; i < string1.length() ; i++) {
			if(!string2.contains(string1.substring(i, i+1))) {
				removedString += (string1.substring(i, i+1));
			}
		}
		
		for(int i = 0 ; i < string2.length() ; i++) {
			if(!string1.contains(string2.substring(i, i+1))) {
				removedString += (string2.substring(i, i+1));
			}
		}
		
		String res = "";
		for(int i = 0; i < removedString.length(); i++) {
			res += removedString.charAt(i) + ",";
		}
		
		System.out.print("Output = " + removedString.length() + " # ");
		if(removedString.length() == 0) {
			System.out.println("no need to remove");
		} else {
			System.out.println("removing " + res.substring(0, res.length() - 1));
		}
		
		
	}
}
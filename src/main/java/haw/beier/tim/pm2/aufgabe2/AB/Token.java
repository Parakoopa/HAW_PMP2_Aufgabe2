package haw.beier.tim.pm2.aufgabe2.AB;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Token {

	public static String getToken(String line, int curToken) {

		Pattern p = Pattern.compile("\\d|\\(|\\)|\\+|\\-|\\*|\\/");
		Matcher m = p.matcher(line);
		m.find();

		while (m.group(curToken) != null) {
			return m.group(curToken);
		}
		throw new IndexOutOfBoundsException();
	}
}

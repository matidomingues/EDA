package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

	private Pattern pat1 = Pattern.compile(".*\\begin{(.+)}.*");
	private Pattern pat2 = Pattern.compile(".*\\end{(.+)}.*");

	public boolean parser(String fileName) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		Stack<String> data = new Stack<String>();
		while ((line = in.readLine()) != null) {
			Matcher matcher = pat1.matcher(line);
			while (matcher.find()) {
				data.push(matcher.group(1));
			}
			matcher = pat2.matcher(line);
			while (matcher.find()) {
				if (data.pop() != matcher.group(1)) {
					return false;
				}
			}
		}
		return true;
	}
}

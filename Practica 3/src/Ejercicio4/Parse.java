package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

	public boolean parser(String fileName) throws IOException {
		String line;
		String aux;
		BufferedReader in = new BufferedReader(new FileReader(
				"C:/Users/mati/git/EDA/Practica 3/src/Ejercicio4/" + fileName));
		Stack<String> data = new Stack<String>();
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			Pattern pat1 = Pattern.compile("\\\\(begin|end)\\{(\\w+)\\}");
			Matcher matcher = pat1.matcher(line);
			while (matcher.find()) {
				System.out.println(matcher.group(1));
				System.out.println(matcher.group(2));
				if (matcher.group(1).equals("begin")) {
					data.push(matcher.group(2));
				} else {
					if (data.isEmpty()) {
						return false;
					}
					if ((aux = data.pop()) == null
							|| !aux.equals(matcher.group(2))) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

package Ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

	

	public boolean parser(String fileName) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new FileReader("/home/matdomin/EDA/Practica 3/src/Ejercicio4/"+fileName));
		Stack<String> data = new Stack<String>();
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			Pattern pat1 = Pattern.compile("\\begin([^}]*)");
			Pattern pat2 = Pattern.compile("\\end(.+)");
			Matcher matcher = pat1.matcher(line);
			while (matcher.find()) {
				System.out.println(matcher.group(1));
				data.push(matcher.group(1));
			}
			matcher = pat2.matcher(line);
			while (matcher.find()) {
				System.out.println(matcher.group(1));
				if (data.pop() != matcher.group(1)) {
					return false;
				}
			}
		}
		return true;
	}
}

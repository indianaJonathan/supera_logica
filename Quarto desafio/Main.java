package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		InputData data = getInput();
		String[] decoded = decode(data.getPhrases());
		for(String phrase : decoded) {
			System.out.println(phrase);
		}
	}
	
	private static InputData getInput() {
		Scanner scanner = new Scanner(System.in);
		
		InputData data = new InputData();
		
		int lines = scanner.nextInt();
		scanner.nextLine();
		String[] phrases = new String[lines];
		for (int i = 0; i < phrases.length; i++) {
			phrases[i] = scanner.nextLine();
		}
		scanner.close();
		
		data.setLines(lines);
		data.setPhrases(phrases);
		
		return data;
	}
	
	private static String[] decode(String[] data) {
		String[] decoded = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			String firstPart = reverse(data[i].substring((data[i].length() / 2), data[i].length()));
			String secondPart = reverse(data[i].substring(0, data[i].length() / 2));
			decoded[i] = secondPart.concat(firstPart);
		}
		return decoded;
	}
	
	private static String reverse (String phrase) {
		String reverse = "";
		for (int i = 0; i < phrase.length(); i++) {
			char ch = phrase.charAt(i);
			reverse = ch + reverse;
		}
		return reverse;
	}
}
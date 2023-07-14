package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		List<Integer> numbers = getNumbers();
		List<Integer> ordered = orderNumbers(numbers);
		for (Integer number : ordered) {
			System.out.println(number);
		}
	}
	
	private static List<Integer> getNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);

		int count = scanner.nextInt();
		
		for (int i = 0; i < count; i++ ) {
			int number = scanner.nextInt();
			numbers.add(number);
		}
		
		scanner.close();
		return numbers;
	}
	
	private static List<Integer> orderNumbers(List<Integer> numbers) {
		List<Integer> even = new ArrayList<Integer>();
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> all = new ArrayList<Integer>();
		
		for (Integer number : numbers) {
			if (number % 2 == 0) {
				even.add(number);
			} else {
				odd.add(number);
			}
		}
		Collections.sort(even);
		Collections.sort(odd, (n1, n2) -> {
			return n2 - n1;
		});
		
		all.addAll(even);
		all.addAll(odd);
		return all;
	}
}
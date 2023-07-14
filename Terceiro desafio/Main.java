package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		InputData data = getInput();
		int result = checkDiference(data.getArray(), data.getTarget());
		System.out.println(result);
	}
	
	private static InputData getInput() {
		InputData data = new InputData();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Tamanho da Array: ");
		int size = scanner.nextInt();
		System.out.print("Valor alvo: ");
		int target = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Elemento [" + i + "]: ");
			int entered = scanner.nextInt();
			arr[i] = entered;
		}
		scanner.close();
		data.setSize(size);
		data.setTarget(target);
		data.setArray(arr);
		return data;
	}
	
	private static int checkDiference(int[] arr, int target) {
		int equalTarget = 0;
		for (Integer n : arr) {
			for (Integer aux : arr) {
				if (n - aux == target) equalTarget++;
			}
		}
		return equalTarget;
	}
}
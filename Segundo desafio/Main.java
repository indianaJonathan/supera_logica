package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		double[] CashValues = {100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.10, 0.05, 0.01};
		df.setRoundingMode(RoundingMode.UP);
		float value = Float.parseFloat(df.format(getValue()).replaceAll(",", "."));
		float currentValue = value;
		
		List<CashCounter> cashes = new ArrayList<CashCounter>();
		
		for (double note_coin : CashValues) {
			String type = note_coin > 1 ? "note" : "coin";
			CashCounter qtt = getQuantity(note_coin, currentValue, type);
			cashes.add(qtt);
			currentValue = qtt.getValue();
		}
		System.out.println("NOTAS:");
		for (CashCounter cash : cashes) {
			if (cash.getType().equals("note")) System.out.println(cash.getQuantity() + " nota(s) de R$" + df.format(cash.getAmmount()).replaceAll(",", "."));
		}
		System.out.println("MOEDAS:");
		for (CashCounter cash : cashes) {
			if (cash.getType().equals("coin")) System.out.println(cash.getQuantity() + " moeda(s) de R$" + df.format(cash.getAmmount()).replaceAll(",", "."));
		}
	}
	
	private static double getValue() {
		Scanner scanner = new Scanner(System.in);
		String entered = scanner.nextLine();
		float value = Float.parseFloat(entered);
		scanner.close();
		
		return value;
	}
	
	private static CashCounter getQuantity(double noteValue, float value, String type) {
		CashCounter counter = new CashCounter();
		counter.setAmmount(noteValue);
		counter.setType(type);
		Integer qtt = 0;
		
		while (value >= 0) {
			double aux = value - noteValue;
			if (aux >= 0) value -= noteValue; else break;
			qtt++;
		}
		
		counter.setQuantity(qtt);
		counter.setValue(value);
		
		return counter;
	}
}
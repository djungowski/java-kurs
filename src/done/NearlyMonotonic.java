package done;

public class NearlyMonotonic
{
	public static void main(String[] args)
	{
		// Aktuell werden nur 4 Zahlen unterstuetzt
		final int amountNumbers = 4;
		final int countMininum = amountNumbers - 2;
		
		final int number1 = Integer.parseInt(args[0]);
		final int number2 = Integer.parseInt(args[1]);
		final int number3 = Integer.parseInt(args[2]);
		final int number4 = Integer.parseInt(args[3]);
		
		// Bsp: 9 10 3 4
		// delta1: 10 - 9 = 1
		// delta2: 3 - 9 = -6
		// delta3: 4 - 9 = -5
		
		// Bsp: 5 7 2 10
		// delta1: 7 - 5 = 2
		// delta2: 2 - 5 = -3
		// delta3: 10 - 5 = 5
		
		int increasingCount = 0;
		int decreasingCount = 0;
		
		if (number1 < number2) increasingCount++;
		if (number1 < number3 && number2 < number3) increasingCount++;
		if (number1 < number4 && number3 < number4) increasingCount++;
		
		if (number1 > number2) decreasingCount++;
		if (number1 > number3 && number2 > number3) decreasingCount++;
		if (number1 > number4 && number3 > number4) decreasingCount++;
		
		if (increasingCount >= countMininum) {
			System.out.println(1);
		} else if (decreasingCount >= countMininum) {
			System.out.println(-1);
		} else {
			System.out.println(0);
		}
	}
}

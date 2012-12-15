package done;
public class Diamond
{
	public static void main(String[] args)
	{
		int rows = Integer.parseInt(args[0]);
		if (rows % 2 == 0 || rows < 3) {
			System.out.println("Bitte eine ungerade Zahl (mind. 3) angeben!");
			return;
		}
		
		DiamondPrinter printer = new DiamondPrinter();
		printer.print(rows);
	}
}

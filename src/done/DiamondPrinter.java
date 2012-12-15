package done;
/**
 * Klasse, die in der Lage ist einen Diamanten auf der Konsole auszugeben.
 * 
 * @author djungowski
 */
public class DiamondPrinter
{
	// Anzahl der Zeilen des Diamanten
	int rows;
	
	// Mittlere Zeile des Diamanten
	int center;
	
	// Anzahl der aktuell auszugebenden # Symbole
	int sharps = 1;
	
	// Anzahl der aktuell auszugebenden Leerzeichen
	int spaces;
	
	/**
	 * Den Diamanten ausgeben
	 * 
	 */
	public void print(int rows)
	{
		this.setRows(rows);
		// Berechne die mittlere Zeile des Diamanten
		for (int i = 1; i <= this.rows; i++) {
			// Zeile 1: 1 Raute, Zeile 2: 3 Rauten, etc.
			System.out.print(this.createSpaces());
			System.out.println(this.createSharps());
			this.prepareForNextRow(i);
		}
	}
	
	/**
	 * Anzahl der Zeilen fuer den Diamanten setzen
	 * 
	 * @param rows
	 */
	public void setRows(int rows)
	{	
		this.rows = rows;
		this.center = (int) Math.ceil(this.rows / 2);
		this.spaces = (int) Math.floor((this.rows - 1) / 2);
	}
	
	/**
	 * Fuer die aktuelle Zeile die Rauten erzeugen
	 * 
	 * @return String mit den Rauten
	 */
	private String createSharps()
	{
		String sharps = "";
		for (int i = 0; i < this.sharps; i++) {
			sharps = sharps + "#";
		}
		return sharps;
	}
	
	/**
	 * Fuer die aktuelle Zeile die Leerzeichen erzeugen
	 * 
	 * @return String mit den Leerzeichen
	 */
	private String createSpaces()
	{
		String spaces = "";
		for (int i = 0; i < this.spaces; i++) {
			spaces = spaces + " ";
		}
		return spaces;
	}
	
	/**
	 * Zaehler fuer die naechste Zeile setzen, heißt entweder
	 * hoch oder runterzaehlen
	 * 
	 * @param currentIndex
	 */
	private void prepareForNextRow(int currentIndex)
	{
		if (currentIndex <= this.center) {
			this.spaces--;
			this.sharps = this.sharps + 2;
		} else if (currentIndex > this.center) {
			this.spaces++;
			this.sharps = this.sharps - 2;
		}
	}
}

package done;


public class Plateau
{
	public static void main(final String[] ignored)
	{
		// Vorheriger Wert der Zahlenreihe
		int previousValue = 0;
		
		// Zaehlwerte fuer das laengste Plateau der Zahlenreihe
		int longestPlateauLength = 0;
		int longestPlateauBeginsAtIndex = 0;
		
		// Zaehlwerte fuer das Plateau, das in der Schleife aktuell ausgewertet wird
		int currentPlateauLength = 0;
		int currentPlateauBeginsAtIndex = 0;
		
		// Aktueller Index, an dem wir uns befinden
		int currentIndex = 0;
		
		int value = DataSource.next();
		while (value >= 0) {
			if (currentIndex > 0) {
				// Neues Plateau anfangen
				if (value > previousValue) {
					currentPlateauBeginsAtIndex = currentIndex;
					currentPlateauLength = 1;
				// Plateau verlaengern, wenn der Wert gleich bleibt
				} else if (currentPlateauLength > 0 && value == previousValue) {
					currentPlateauLength++;
				} else {
					// Wenn es aktuell ein Plateau gibt und das Plateau laenger ist
					// als das bisher laengste Plateau, dann dieses als neues laengstes
					// Plateau uebernehmen
					if (currentPlateauLength > 0 && currentPlateauLength > longestPlateauLength) {
						longestPlateauLength = currentPlateauLength;
						longestPlateauBeginsAtIndex = currentPlateauBeginsAtIndex;
						
						// Werte fuer aktuelles Plateau zuruecksetzen
						currentPlateauLength = 0;
						currentPlateauBeginsAtIndex = 0;
					}
				}
			}
			
			// Werte nur hochzaehlen, solange wir uns nicht am Ende der Zahlenreihe befinden
			// Ende der Zahlenreihe ist erreicht, wenn der 0 zurueckgegeben wird
			if (value > 0) {
				previousValue = value;
				value = DataSource.next();
				currentIndex++;
			} else {
				// Wurde der Wert 0 zurueckgegeben, value auf -1 setzen, damit die while-Schleife beendet wird.
				value = -1;
			}
		}
		
		System.out.println(longestPlateauLength);
		System.out.println(longestPlateauBeginsAtIndex);
	}
}

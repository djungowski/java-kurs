package done;
/**
 * Zahlen von Textzeichen, Woertern und Saetzen
 * 
 * Ein Wort ist eine zusammenhängende Folge von einem oder mehreren Textzeichen.
 * Ein Satz ist eine Folge von wenigstens einem Wort und einem nachfolgenden Satztrenner. Zwischenraum spielt für Sätze keine Rolle.
 * 
 * Bekannte Satztrenner:
 * .  :  ;  !  ?
 * 
 * @author djungowski
 *
 */
public class TextCounts
{
	public static void main(String[] args)
	{
		// Anzahl der Buchstaben im gelieferten String
		int letterCount = 0;
		// Anzahl der Woerter im gelieferten String
		int wordCount = 0;
		// Anzahl der Saetze im gelieferten String
		int sentenceCount = 0;
		// Zaehler fuer aktuelle Woerter im angefangenen Satz
		int sentenceWordCount = 0;
		// Bekannte Satztrenner
		final String splitters = ".:;!?";
		
		// Angabe, ob wir uns gerade in einem Wort befinden
		boolean inWord = false;
		
		// Text der geliefert wird
		final String text = TextInput.getText();
		
		// Aktueller Index fuer die Schleife
		int index = 0;
		// Methoden in einem Schleifenkopf aufzurufen ist ein code smell, deswegen in eine Variable schreiben
		final int textLength = text.length();
		
		// Segment 1: Textzeichen zahlen
		for (index = 0; index < textLength; index++) {
			// Das aktuelle Zeichen anhand von index aus dem gelieferten String auslesen
			final Character currentChar = text.charAt(index);
			if (Character.isLetterOrDigit(currentChar)) {
				letterCount++;
			}
		}
		
		// Segment 2: Woerter zahlen
		for (index = 0; index < textLength; index++) {
			// Das aktuelle Zeichen anhand von index aus dem gelieferten String auslesen
			final Character currentChar = text.charAt(index);
			if (Character.isLetterOrDigit(currentChar) && inWord == false) {
				// Ist es ein Wortanfang, dann mitzaehlen und inWord auf true setzen
				// Ein Wortanfang ist dann gegegben, wenn inWord false ist und ein Textzeichen kommt.
				inWord = true;
				wordCount++;
				
			// Ein Wort geht bei einem Space zu Ende. inWord auf false setzen
			} else if (Character.isLetterOrDigit(currentChar) == false) {
				inWord = false;
			}
		}
		
		// Segment 3: Saetze zaehlen
		for (index = 0; index < textLength; index++) {
			final Character currentChar = text.charAt(index);
			
			// Sobald irgendein Textzeichen auftritt, gibt es auch ein Wort im Satz
			if (Character.isLetterOrDigit(currentChar)) {
				sentenceWordCount++;
				
			// Pruefen, ob ein Satz zu Ende gegangen ist
			} else {
				
				// Aktueller Index fuer die Satztrenner-Schleife
				int splitIndex = 0;
				// siehe oben ;)
				final int splittersStringLength = splitters.length();
				
				// Ein Satz ist dann zu Ende, wenn das aktuelle Zeichen einer der bekannten Satztrenner ist
				// (Variable splitters)
				while (splitIndex < splittersStringLength) {
					boolean isSentence = currentChar == splitters.charAt(splitIndex);
					// Es gibt nur einen Satz, wenn es auch mindestens ein Wort gibt
					isSentence = isSentence && sentenceWordCount > 0;
					// Ist das Zeichen ein Satztrenner Saetze +1 und die Schleife beenden
					if (isSentence) {
						sentenceCount++;
						sentenceWordCount = 0;
						break;
					}
					splitIndex++;
				}
			}
		}
		
		System.out.println(letterCount);
		System.out.println(wordCount);
		System.out.println(sentenceCount);
	}
}
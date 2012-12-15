
final public class StringLetterSet implements LetterSet
{
	final private String alphabet = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
	final private String letterSet;
	
	public StringLetterSet()
	{
		this.letterSet = "";
	}
	
	/**
	 * Klasse mit Buchstabensatz erzeugen
	 * 
	 * @param letterSet
	 * @throws RuntimeException
	 */
	public StringLetterSet(String letterSet)
	{
		this.checkLetters(letterSet);
		
		this.letterSet = letterSet;
	}
	
	private final void checkLetters(String letters)
	{
		if (letters == null) {
			throw new RuntimeException("letters darf nicht null sein");
		}
		if (!letters.matches("[A-Z]*")) {
			throw new RuntimeException("letters enthaelt ungueltige Zeichen");
		}
	}
	
	/**
	 * Einen Buchstabensatz sortieren
	 * 
	 * @param letterSet
	 * @return sortierter letterSet
	 */
	private final String sortAndUnifyLetterSet(String letterSet)
	{
		String sortedLetterSet = "";
		final int alphabetLength = this.alphabet.length();
		// Das Alphabet einzeln durchgehen
		for (int index = 0; index < alphabetLength; index++) {
			final String currentLetter = String.valueOf(this.alphabet.charAt(index));
			// Wenn sich das Zeichen aus dem Alphabet im letterSet befindet, dieses in sortedLetterSet mit aufnehmen
			if (letterSet.contains(currentLetter)) {
				sortedLetterSet += currentLetter;
			}
		}
		return sortedLetterSet;
	}
	
	public String toString()
	{
		String letterSet = this.sortAndUnifyLetterSet(this.letterSet);
		return letterSet;
	}
	
	public int size()
	{
		return this.letterSet.length();
	}
	
	public boolean isEmpty()
	{
		return this.letterSet.isEmpty();
	}
	
	public LetterSet add(String letters)
	{
		this.checkLetters(letters);
		String lettersConcatinated = this.letterSet + letters;
		lettersConcatinated = this.sortAndUnifyLetterSet(lettersConcatinated);
		StringLetterSet newLetterSet = new StringLetterSet(lettersConcatinated);
		return newLetterSet;
	}
	
	public LetterSet remove(String letters)
	{
		this.checkLetters(letters);
		String lettersShortened = this.letterSet.replaceAll("[" + letters + "]", "");
		StringLetterSet newLetterSet = new StringLetterSet(lettersShortened);
		return newLetterSet;
	}
	
	public boolean contains(char letter)
	{
		this.checkLetters(String.valueOf(letter));
		return this.letterSet.contains(String.valueOf(letter));
	}
	
	public boolean containsAll(String letters)
	{
		this.checkLetters(letters);
		letters = this.sortAndUnifyLetterSet(letters);
		final int lettersLength = letters.length();
		for (int index = 0; index < lettersLength; index++) {
			final char currentLetter = letters.charAt(index);
			if (this.letterSet.indexOf(currentLetter) == -1) {
				return false;
			}
		}
		return true;
	}
}

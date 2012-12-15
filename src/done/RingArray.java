package done;

public class RingArray
{
	private final int[] array;
	
	public RingArray(int... elements)
	{
		this.array = elements;
	}
	
	private int getAbsoluteIndex(int index)
	{
		final int absoluteIndex;
		
		// Wenn ein Index angefordert wird, der hoeher ist als das was es gibt:
		// Ermitteln welcher Wert zurueckgegeben werden muss
		if (index >= 0) {
			// Beispiel: Index 3, 4, 5, 12, 13, 14
			// bei Array laenge 3
			// 3 % 3 = 0 => index 0
			// 4 % 3 = 1 => index 1
			// 5 % 3 = 2 => index 2
			absoluteIndex = index % this.array.length;
		} else {
			// Beispiel Array (1, 2, 3)
			// Index -1 gibt index 2 aus
			// Index -2 gibt index 1 aus
			// Index -3 gibt index 0 aus
			// Index -4 gibt index 2 aus
			// Index -5 gibt index 1 aus
			// Index -6 gibt index 0 aus
			int substractor = Math.abs(index) % this.array.length;
			// Index -3 muss index 0 ergeben
			// Math.abs(-3) % 3 = 0
			// 3 - 0 = 3
			// Sonderfall: Wenn der Modulo 0 ergibt, die Arraylaenge verwenden
			if (substractor == 0) {
				substractor = this.array.length;
			}
			absoluteIndex = this.array.length - substractor;
		}

		return absoluteIndex;
	}
	
	/**
	 * Array an Position index ausgeben
	 * 
	 * @param index
	 * @return Wert an Position index
	 */
	public int get(int index)
	{
		final int ringIndex = this.getAbsoluteIndex(index);
		return this.array[ringIndex];
	}
	
	/**
	 * Wert an position index mit value neu setzen
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, int value)
	{
		final int ringIndex = this.getAbsoluteIndex(index);
		this.array[ringIndex] = value;
	}
	
	/**
	 * Ueberpruefen, ob 2 RingArrays gleich sind
	 * 
	 * @param that
	 * @return Angabe, ob die Arrays gleich sind
	 */
	public boolean isSame(RingArray that)
	{
		boolean isSame = true;
		
		// Das eigene Array ist nicht leer
		if (this.array.length > 0) {
			RingArray baseArray = this;
			RingArray compareArray = that;
			// Entscheiden, ob that als Pruefungsgrundlage verwendet werden soll
			if (that.array.length > this.array.length) {
				baseArray = that;
				compareArray = this;
			}
			isSame = this.compareArrays(baseArray, compareArray);
		} else {
			isSame = (this.array.length == that.array.length);
		}

		return isSame;
	}
	
	/**
	 * 2 RingArrays genau miteinander vergleichen
	 * 
	 * @param baseArray
	 * @param compareArray
	 * @return Sind die Arrays gleich
	 */
	private boolean compareArrays(RingArray baseArray, RingArray compareArray)
	{
		boolean isSame = true;
		final int denominator = baseArray.array.length - 1;
		
		// Pruefen, ob alle Schluessel des eigenen Arrays mit dem
		// anderen Array uebereinstimmen
		for (int i = 0; i <= denominator; i++) {
			// Wenn hier eine Exception geworfen wird, ist eines der beiden
			// Arrays leer
			try {
				// 1 & 1 = 1
				// 1 & 0 = 0
				isSame &= (baseArray.get(i) == compareArray.get(i));
			} catch (Exception e) {
				isSame &= false;
			}
		}
		return isSame;
	}
}
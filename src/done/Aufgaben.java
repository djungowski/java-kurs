package done;
import java.util.HashMap;

public class Aufgaben
{
	public static void main(String[] args)
	{
		System.out.println("Aufgabe a) countNeedles");
		int count = Aufgaben.countNeedles('a', "Donaudampfschifffahrtkapitänsmütze");
		System.out.println("Vorkommen von 'a' in 'Donaudampfschifffahrtkapitänsmütze': " + count);
		
		System.out.println("Aufgabe b) sameChars");
		boolean sameChars = Aufgaben.sameChars("Langnese", "Lasagne");
		System.out.println("Langnese und Lasagne gleich? " + sameChars);
		sameChars = Aufgaben.sameChars("Demand", "dnameD");
		System.out.println("Demand und dnameD gleich? " + sameChars);
	}
	
	/**
	 * Zur Lösung dieser Aufgabe sind die beiden String-Methoden length und charAt erlaubt, aber keine anderen.
	 * Verwenden Sie zur Lösung dieser Aufgabe keine Arrays.
	 * a.) Die statische Methode countNeedles zählt ab, wie oft das Zeichen needle im String haystack vorkommt
	 * @param needle
	 * @param haystack
	 * @return
	 */
	static int countNeedles(char needle, String haystack)
	{
		int count = 0;
		for (int index=0; index < haystack.length(); index++) {
			if (haystack.charAt(index) == needle) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * b.) Die statische Methode sameChars gibt Auskunft, ob die beiden Strings s0 und s1 aus den gleichen Zeichen
	 * bestehen (true) oder nicht (false). Anzahl und Position der Zeichen in den Strings sind ohne Bedeutung.
	 * Nutzen Sie countNeedles. Definieren Sie ggf. eine Hilfsmethode, um duplizierten Code zu vermeiden.
	 */
	static boolean sameChars(String s0, String s1)
	{
		HashMap<Character, Integer> mapS0 = Aufgaben.createHashMapForString(s0);
		HashMap<Character, Integer> mapS1 = Aufgaben.createHashMapForString(s1);
		return mapS0.equals(mapS1);
	}
	
	/**
	 * Erzeuge aus einem String eine Hashmap, die als Information beinhaltet
	 * aus welchen Strings mit wievielen Vorkommen der Ursprungsstring besteht
	 * 
	 * @param string
	 * @return
	 */
	static HashMap<Character, Integer> createHashMapForString(String string)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// Uebergebenen String in Char Array umwandeln
		char[] characters = string.toCharArray();
		int count;
		
		for (int i=0; i < characters.length; i++) {
			if (!map.containsKey(characters[i])) {
				count = Aufgaben.countNeedles(characters[i], string);
				map.put(characters[i], count);
			}
		}
		return map;
	}
}

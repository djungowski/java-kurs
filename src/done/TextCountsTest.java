package done;
import UnitTestStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Bekannte Satztrenner:
 * 
 * .  :  ;  !  ?
 * 
 * @author djungowski
 *
 */
public class TextCountsTest
{	
	private UnitTestStream stream;
	
	public TextCountsTest() throws FileNotFoundException
	{
		super();
		this.stream = new UnitTestStream("foobar.txt");
		System.setOut(this.stream);
	}
	
	private void testText(String text, int textSymbols, int words, int sentences)
	{
		System.setProperty("edu.hm.cs.rs.textinput", text);
		// 15 Zeichen, 3 Wörter, 1 Satz
		ArrayList<Integer> expected = this.createExpected(textSymbols, words, sentences);
		ArrayList<Integer> actual = this.getActual();
		try {
			assertEquals(expected, actual);
		} catch (AssertionError e) {
			String message = "Text: \"" + text + "\" " + e.getMessage(); 
			AssertionError up = new AssertionError(message);
			throw up;
		}
	}
	
	private ArrayList<Integer> createExpected(int textSymbols, int words, int sentences)
	{
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(textSymbols);
		expected.add(words);
		expected.add(sentences);
		return expected;
	}
	
	private ArrayList<Integer> getActual()
	{
		TextCounts.main(null);
		return this.stream.getOutput();
	}
	
	@Test
	public void testBasicCount()
	{
		this.testText("Anybody out there?", 15, 3, 1);
	}

	@Test
	public void testBasicCountWithWhitespace()
	{
		this.testText(" Anybody out there? ", 15, 3, 1);
	}
	
	@Test
	public void testSentences()
	{
		// .  :  ;  !  ?
		this.testText("Satz eins. Satz zwei: Satz drei; Satz vier! Satz fünf?", 40, 10, 5);
	}
	
	@Test
	public void testWordsWithoutSentence()
	{
		// Ein Wort ist eine zusammenhängende Folge von einem oder mehreren Textzeichen.
		// Ein Satz ist eine Folge von wenigstens einem Wort und einem nachfolgenden Satztrenner. Zwischenraum spielt für Sätze keine Rolle.
		this.testText("d f e h ogh u ia", 10, 7, 0);
	}
	
	@Test
	public void testShortestCombo()
	{
		this.testText("A!", 1, 1, 1);
	}
	
	@Test
	public void testSentenceSplitterWithoutSentence()
	{
		this.testText(".f", 1, 1, 0);
	}
	
	@Test
	public void testSentenceSplitterInTheMiddleOfNowhere()
	{
		this.testText("mfk jfsf . f", 8, 3, 1);
	}
	
	@Test
	public void ingoreOtherCharacters()
	{
		this.testText("Anybody#out%there?", 15, 3, 1);
	}
	
	@Test
	public void testWithDigits()
	{
		this.testText("4nyb0dy 0u7 7h3r3?", 15, 3, 1);
	}
	
	@Test
	public void testWithSingleNumberAndSplitter()
	{
		this.testText("1!", 1, 1, 1);
	}
	
	@Test
	public void testWithNothingButWhitespaceAndASplitter()
	{
		this.testText(" !", 0, 0, 0);
	}
	
	@Test
	public void testMultisplitters()
	{
		this.testText("Bla!.;fasel:", 8, 2, 2);
	}
}

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import java.lang.RuntimeException;
import org.junit.rules.ExpectedException;

public class StringLetterSetTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testEmptyConstructor()
	{
		StringLetterSet letterSet = new StringLetterSet();
		assertNotNull(letterSet);
	}
	
	@Test
	public void testNotEmptyConstructor()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		assertNotNull(letterSet);
	}
	
	@Test
	public void testConstructorWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		new StringLetterSet(null);
	}
	
	@Test
	public void testConstructorWithSmallLetters()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		new StringLetterSet("AbCD");
	}
	
	@Test
	public void testToString()
	{
		StringLetterSet letterSet;
		letterSet = new StringLetterSet("CADB");
		assertEquals("ABCD", letterSet.toString());
		
		// Duplikate entfernen
		letterSet = new StringLetterSet("CADDB");
		assertEquals("ABCD", letterSet.toString());
	}
	
	@Test
	public void testSize()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		assertEquals(4, letterSet.size());
	}
	
	@Test
	public void testIsEmptyFalse()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		assertFalse(letterSet.isEmpty());
	}
	
	@Test
	public void testIsEmptyTrue()
	{
		StringLetterSet letterSet;
		
		letterSet = new StringLetterSet("");
		assertTrue(letterSet.isEmpty());
		
		letterSet = new StringLetterSet();
		assertTrue(letterSet.isEmpty());
	}
	
	@Test
	public void testAdd()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		StringLetterSet letterSetNew = (StringLetterSet) letterSet.add("DEF");
		assertEquals("ABCDEF", letterSetNew.toString());
		assertNotSame(letterSet, letterSetNew);
	}
	
	@Test
	public void testAddWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		letterSet.add(null);
	}
	
	@Test
	public void testAddWithInvalidCharacters()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		letterSet.add("DE5F");
	}
	
	@Test
	public void testRemove()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCDEFXYZ");
		StringLetterSet letterSetNew = (StringLetterSet) letterSet.remove("DEY");
		assertEquals("ABCFXZ", letterSetNew.toString());
		assertNotSame(letterSet, letterSetNew);
	}
	
	@Test
	public void testRemoveWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		letterSet.remove(null);
	}
	
	@Test
	public void testRemoveWithInvalidCharacters()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet("ABCD");
		letterSet.remove("*ß434lkfsf7");
	}
	
	@Test
	public void testContains()
	{
		StringLetterSet letterSet = new StringLetterSet("ABCDYZJ");
		assertTrue(letterSet.contains('C'));
		assertFalse(letterSet.contains('U'));
	}
	
	@Test
	public void testContainsWithSmallLetter()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.contains('a');
	}
	
	@Test
	public void testContainsAll()
	{
		StringLetterSet letterSet = new StringLetterSet("ABC");
		assertTrue(letterSet.containsAll("CBAAAA"));
		assertFalse(letterSet.containsAll("CBZ"));
	}
	
	@Test
	public void testContainsAllWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsAll(null);
	}
	
	@Test
	public void testContainsAllWithNumber()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsAll("42");
	}
	
	@Test
	public void testContainsAllWithInvalidChar()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsAll("&");
	}
	
	@Test
	public void testContainsSome()
	{
		StringLetterSet letterSet = new StringLetterSet("ABC");
		assertTrue(letterSet.containsSome("SIMSALABIM"));
		assertFalse(letterSet.containsSome("HORST"));
	}
	
	@Test
	public void testContainsSomeWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsSome(null);
	}
	
	@Test
	public void testContainsSomeWithNumber()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsSome("7");
	}
	
	@Test
	public void testContainsSomeWithInvalidChar()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("ungueltige Zeichen");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.containsSome("@");
	}
	
	@Test
	public void testContainsSomeWithEmptyString()
	{
		StringLetterSet letterSet = new StringLetterSet("ABC");
		assertFalse(letterSet.containsSome(""));
	}
	
	@Test
	public void testUnite()
	{
		StringLetterSet first = new StringLetterSet("ABCDEF");
		StringLetterSet second = new StringLetterSet("BDFXYZ");
		StringLetterSet expected = (StringLetterSet) first.unite(second);
		assertNotSame(first, expected);
		assertNotSame(second, expected);
		assertEquals("ABCDEFXYZ", expected.toString());
	}
	
	@Test
	public void testUniteWithNull()
	{
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("null");
		StringLetterSet letterSet = new StringLetterSet();
		letterSet.unite(null);
	}
}

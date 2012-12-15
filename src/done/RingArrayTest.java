package done;
import org.junit.*;
import static org.junit.Assert.*;
import java.lang.RuntimeException;

public class RingArrayTest
{
	@Test
	public void testCreation()
	{
		RingArray ringArray = new RingArray(1, 2, 3);
		assertNotNull(ringArray);
	}
	
	@Test
	public void testGet()
	{
		RingArray ringArray = new RingArray(1, 2, 3);
		assertEquals(1, ringArray.get(0));
		assertEquals(2, ringArray.get(1));
		assertEquals(3, ringArray.get(2));
	}
	
	@Test
	public void testGetRingPositiveWithLength3()
	{
		RingArray ringArray = new RingArray(1, 2, 3);
		// Ring geht ueber Anzahl Elemente hinaus
		assertEquals(1, ringArray.get(3));
		assertEquals(2, ringArray.get(4));
		assertEquals(3, ringArray.get(5));
		
		assertEquals(1, ringArray.get(12));
		assertEquals(2, ringArray.get(13));
		assertEquals(3, ringArray.get(14));
		
		assertEquals(2, ringArray.get(1_000));
	}
	
	@Test
	public void testGetRingPositiveWithLength7()
	{
		RingArray ringArray = new RingArray(5, 2, 8, 1, 9, 5, 6);
		assertEquals(8, ringArray.get(2));
		assertEquals(8, ringArray.get(9));
	}
	
	@Test
	public void testGetRingNegativeWithLength4()
	{
		RingArray ringArray = new RingArray(5, 2, 8, 1);
		assertEquals(1, ringArray.get(-1));
		assertEquals(8, ringArray.get(-2));
		assertEquals(5, ringArray.get(-4));
		assertEquals(2, ringArray.get(-7));
	}
	
	@Test
	public void testGetRingNegativeWithLength9()
	{
		RingArray ringArray = new RingArray(5, 2, 8, 1, 9, 5, 6, 4, 7);
		assertEquals(7, ringArray.get(-1));
		assertEquals(6, ringArray.get(-3));
		assertEquals(6, ringArray.get(-12));
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetException() throws RuntimeException
	{
		RingArray ringArray = new RingArray();
		ringArray.get(0);
	}
	
	@Test
	public void testSet()
	{
		RingArray ringArray = new RingArray(4, 8, 1);
		ringArray.set(1, 42);
		assertEquals(42, ringArray.get(1));
		
		ringArray.set(-2_000_000_000, 4);
		assertEquals(4, ringArray.get(1));
		
		ringArray.set(-4, 1337);
		assertEquals(1337, ringArray.get(2));
	}
	
	@Test(expected=RuntimeException.class)
	public void testSetException() throws RuntimeException
	{
		RingArray ringArray = new RingArray();
		ringArray.set(1, 5);
	}
	
	@Test
	public void testIsSameFalse()
	{
		RingArray array1 = new RingArray(1, 2, 3);
		RingArray array2 = new RingArray();
		assertFalse(array1.isSame(array2));
		assertFalse(array2.isSame(array1));
		
		RingArray array3 = new RingArray(1, 2, 3);
		RingArray array4 = new RingArray(3, 4, 5, 6);
		assertFalse(array3.isSame(array4));
		assertFalse(array4.isSame(array3));
	}
	
	@Test
	public void testIsSameTrue()
	{
		RingArray array1 = new RingArray(1, 2, 3);
		RingArray array2 = new RingArray(1, 2, 3);
		assertTrue(array1.isSame(array2));
		assertTrue(array2.isSame(array1));
	}
	
	@Test
	public void testIsSameTrueWithDifferentLengths()
	{
		RingArray array1 = new RingArray(1, 2, 3, 1, 2, 3, 1, 2, 3, 1);
		RingArray array2 = new RingArray(1, 2, 3);
		assertTrue(array1.isSame(array2));
		assertTrue(array2.isSame(array1));
	}
	
	@Test
	public void testIsSameFalseWithPartialEquality()
	{
		RingArray array1 = new RingArray(1, 2, 3);
		RingArray array2 = new RingArray(1, 2, 3, 4);
		assertFalse(array1.isSame(array2));
	}
	
	@Test
	public void testIsSameTrueWithEmptyArrays()
	{
		RingArray array1 = new RingArray();
		RingArray array2 = new RingArray();
		assertTrue(array1.isSame(array2));
		assertTrue(array2.isSame(array1));
	}
	
	@Test(expected=RuntimeException.class)
	public void testIsSameException()
	{
		RingArray ringArray = new RingArray();
		assertTrue(ringArray.isSame(null));
	}
}

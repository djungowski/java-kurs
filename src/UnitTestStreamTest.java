
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class UnitTestStreamTest
{
	@Test
	public void testGetOuput() throws FileNotFoundException
	{
		UnitTestStream stream = new UnitTestStream("foobar.txt");
		stream.println(5);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(5);
		
		ArrayList<Integer> actual = stream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetOutputWithMultipleLines() throws FileNotFoundException
	{
		UnitTestStream stream = new UnitTestStream("foobar.txt");
		stream.println(42);
		stream.println(1337);
		stream.println(548);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(42);
		expected.add(1337);
		expected.add(548);
		
		ArrayList<Integer> actual = stream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWithSystemSetOut() throws FileNotFoundException
	{
		UnitTestStream stream = new UnitTestStream("foobar.txt");
		System.setOut(stream);
		System.out.println(1337);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1337);
		ArrayList<Integer> actual = stream.getOutput();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWithSystemSetOutWithMultipleLines() throws FileNotFoundException
	{
		UnitTestStream stream = new UnitTestStream("foobar.txt");
		System.setOut(stream);
		System.out.println(1337);
		System.out.println(42);
		System.out.println(23);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1337);
		expected.add(42);
		expected.add(23);
		ArrayList<Integer> actual = stream.getOutput();
		
		assertEquals(expected, actual);
	}
}

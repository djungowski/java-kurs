package done;
import UnitTestStream;

import java.util.*;
import java.lang.Exception;
import org.junit.*;
import static org.junit.Assert.*;

public class PlateauTest
{
	private UnitTestStream unitTestStream;
	private Properties props;
	
	@Before
	public void setUp() throws Exception
	{
		this.unitTestStream = new UnitTestStream("foobar.txt");
		System.setOut(this.unitTestStream);
		
		this.props = new Properties();
		System.setProperties(this.props);
	}
	
	@Test
	public void testCheckPlateauWith122()
	{
		this.props.setProperty("values", "1,2,2");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(1);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith12133()
	{
		this.props.setProperty("values", "1,2,1,3,3");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(3);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckPlateauWith1213()
	{
		this.props.setProperty("values", "1,2,1,3");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(1);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckPlateauWith123()
	{
		this.props.setProperty("values", "1,2,3");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith321()
	{
		this.props.setProperty("values", "3,2,1");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith3211()
	{
		this.props.setProperty("values", "3,2,1,1");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith32112()
	{
		this.props.setProperty("values", "3,2,1,1,2");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(4);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith321121()
	{
		this.props.setProperty("values", "3,2,1,1,2,1");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(4);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckPlateauWith222()
	{
		this.props.setProperty("values", "2,2,2");
		DataSource.reset();
		Plateau.main(null);
		
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(0);
		
		ArrayList<Integer> actual = this.unitTestStream.getOutput();
		assertEquals(expected, actual);
	}
}

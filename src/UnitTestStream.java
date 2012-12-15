
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;


public class UnitTestStream extends PrintStream
{
	private ArrayList<Integer> output;

	public UnitTestStream(String fileName) throws FileNotFoundException
	{
		super(fileName);
		this.output = new ArrayList<Integer>();
	}

	@Override
	public void println(int x)
	{
		this.output.add(x);
	}
	
	public ArrayList<Integer> getOutput()
	{
		return this.output;
	}
}

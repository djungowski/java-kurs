package done;
public class HelloGenerator
{
	public static void main(String[] args)
	{	
		System.out.println("" +
			"/**" +
			" * A simple class that prints trivial things like Hello World" +
			" * " +
			" * @author djungowski" +
			" */" +
			"public class Hello" +
			"{" +
			"	/**" +
			"	 * Main" +
			"	 */" +
			"	public static void main(String... args)" +
			"	{" +
			"		System.out.println(\"Hello World\");" +
			"	}" +
			"}"
		);
	}
}

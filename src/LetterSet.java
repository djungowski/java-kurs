
public interface LetterSet
{
	public int size();
	public boolean isEmpty();
	public LetterSet add(String letters);
	public LetterSet remove(String letters);
	public boolean contains(char letter);
}

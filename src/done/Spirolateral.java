package done;

public class Spirolateral
{
	public static void main(String[] args)
	{
		final double angle = Double.valueOf(args[0]);
		final int counter = Integer.parseInt(args[1]);
		final int pixel = Integer.parseInt(args[2]);
		final double size = Double.valueOf(args[3]);
		
		final painter.Turtle turtle = painter.TurtleFactory.make(pixel, size);
		turtle.lineWidth(3);
		turtle.colors(counter);
		
		double totalAngle;
		double modulo = 1.0;
		
		for (totalAngle = 0.0; modulo != 0; modulo = totalAngle % 360) {
			int color = counter;
			for (int distance = 1; distance <= counter; distance++) {
				turtle.color(color--);
				turtle.move(distance);
				turtle.turn(angle);
				totalAngle += angle;
			}
		}
	}
}

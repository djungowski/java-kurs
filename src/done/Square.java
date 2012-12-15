package done;
/* (C) 2012, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.7.0_07, Linux i386 2.6.32.58
 * lilli (Intel CPU U7300/1300 MHz, 2 Cores, 4096 MB RAM)
 */
/** Demoprogramm fuer die Turtlegrafik.
 * @author Reinhard Schiedermeier, rs@cs.hm.edu
 * @version 2012-09-28
 */
public class Square {
    /** Zeichnet ein Einheitsquadrat.
     * @param ignored Kommandozeilenargumente. Werden ignoriert.
     */
    public static void main(final String... ignored) {
        final int angle = 90;   // Drehwinkel in Grad
        final painter.Turtle turtle = painter.TurtleFactory.make(256, 10.0);
        turtle.move(1);
        turtle.turn(angle);
        turtle.move(1);
        turtle.turn(angle);
        turtle.move(1);
        turtle.turn(angle);
        turtle.move(1);
        turtle.turn(angle);
    }
}
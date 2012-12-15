package done;

import java.util.Arrays;

/* (C) 2012, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.7.0_07, Linux i386 2.6.32.58
 * violet (Intel Core2 CPU 6600/2400 MHz, 2 Cores, 3328 MB RAM)
 */
/** Liefert den Inhalt der Umgebungsvariablen VALUES als Zahlenfolge ueber next-Aufrufe.
 * Wenn diese alle verbraucht sind, wird fortwaehrend 0 geliefert.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2012-09-27
 */
public class DataSource {
    /** Gepufferte Werte, as-is. */
    private static String[] args = System.getProperty("values").split("\\D+");

    /** Anzahl der bereits ausgelieferten Werte. */
    private static int argsUsed = 0;

    /** Liefert den naechsten Wert als ganze Zahl oder 0, wenn es keine Werte mehr gibt.
     * @return Ganze Zahl.
     */
    static int next() {
        if(argsUsed >= args.length)
            return 0;
        if(args[argsUsed].isEmpty())
            return 0;
        return Integer.parseInt(args[argsUsed++]);
    }

    /** Laedt die Werte neu.
     */
    static void reset() {
        args = System.getProperty("values").split("\\D+");
        argsUsed = 0;
    }
}
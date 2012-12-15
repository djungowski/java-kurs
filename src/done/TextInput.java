package done;
/* (C) 2012, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.7.0_09, Linux i386 2.6.32.58
 * rakon (Intel Pentium M processor 1600MHz/1600 MHz, 1 Core, 768 MB RAM)
 */
import java.io.IOException;

/** Utilityklasse, die die Standardeingabe als String liefert.
 * @author Reinhard Schiedermeier, rs@cs.hm.edu
 * @version 2012-10-26
 */
@SuppressWarnings("PMD.NoPackage")
public final class TextInput {
    /** Privater Ctor zum Blockieren von Objekten.
     */
    private TextInput() {
    }

    /** Liest die Standardeingabe bis zum Ende und liefert sie als String zurueck.
     * @return String mit der gesamten Standardeingabe.
     */
    @SuppressWarnings("PMD.AvoidThrowingRawExceptionTypes")
    public static String getText() {
        String input = System.getProperty("edu.hm.cs.rs.textinput");
        if(input == null)
            try {
                final StringBuilder inputBuilder = new StringBuilder();
                int code = System.in.read();
                while(code >= 0) {
                    inputBuilder.append((char)code);
                    code = System.in.read();
                }
                input = inputBuilder.toString();
            }
            catch(IOException ioException) {
                throw new RuntimeException(ioException);
            }
        return input;
    }

}

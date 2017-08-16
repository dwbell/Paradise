package pkg.paradise.hud;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {

    private final int LIMIT;
    private final int CHAT_PIXEL_MAX = 392;

    public JTextFieldLimit(int limit) {
        super();
        this.LIMIT = limit;
    }

    /****************************************************
     * Name: insertString
     * Description: Overrides JTextfields insert, 
     * to allow for bounds checking whilst inserting
     * into said JTextField
     ****************************************************/
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= LIMIT && HUD.stringWidth < CHAT_PIXEL_MAX) {
            System.out.println(getLength());
            super.insertString(offset, str, attr);
        }
    }
}

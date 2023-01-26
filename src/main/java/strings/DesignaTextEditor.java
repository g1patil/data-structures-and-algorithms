package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 2296. Design a Text Editor
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DesignaTextEditor {

    private StringBuilder content;
    private int cursor;
    private static final int read_length = 10;
    public DesignaTextEditor() {
        content = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        content.insert(cursor,text);
        cursor+=text.length();
    }

    public int deleteText(int k) {
        int newCursor = Math.max( 0 , this.cursor - k);
        int oldLength = content.length();
        content.delete(newCursor,cursor);
        this.cursor = newCursor;
        return Math.abs( oldLength - content.length());
    }

    public String cursorLeft(int k) {
        this.cursor = Math.max( cursor - k , 0 );
        int start = Math.max( 0, cursor - read_length );
        return content.substring(start,cursor);
    }

    public String cursorRight(int k) {
        this.cursor = Math.min( content.length() , this.cursor + k );
        int start = Math.max( 0, cursor - read_length );
        return content.substring(start,cursor);
    }

    public static void main(String[] args){
        DesignaTextEditor textEditor = new DesignaTextEditor();

        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));

        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));

        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));

        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorRight(6));
    }

}
